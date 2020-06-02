package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import crypto.CryptoAES;
import model.Usuario;

public class UsuarioDAO {

	public static boolean validar(Usuario usuario) throws Exception {

		String sqlInsert = "SELECT login, senha from usuario where login = ? and senha = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getLogin());

			String senha = usuario.getSenha();
			byte[] bSenha = senha.getBytes("ISO-8859-1");
			String chave = "C:/Users/Cesar/eclipse-workspace/Entrega_final/WebContent/WEB-INF/chave.simetrica";
			CryptoAES caes = new CryptoAES();
			try {
			caes.geraCifra(bSenha, new File(chave));
			} catch(Exception e) {
				e.printStackTrace();
			}
			bSenha = caes.getTextoCifrado();
			String cSenha = Arrays.toString(bSenha);
			stm.setString(2, cSenha);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return false;
	}
}