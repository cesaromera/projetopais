package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(pLogin);
		usuario.setSenha(pSenha);
		UsuarioService service = new UsuarioService();

		if (service.validar(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
