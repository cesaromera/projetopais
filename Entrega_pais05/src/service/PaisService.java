package service;

import model.Pais;

import java.util.ArrayList;

import dao.PaisDAO;

public class PaisService {
	
	PaisDAO dao;
	
	public PaisService() {
		dao = new PaisDAO();
	}
	
	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	
	public void atualizar(Pais pais) {
		 dao.atualizar(pais);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Pais carregar(int id){
		 return dao.carregar(id);
	}
	
	public void menorArea(Pais paises) {
		dao.menorArea(paises);
	}
	
	public long maiorPopulacao(long populacao) {
		return dao.maiorPopulacao(populacao);
	}
	
	public Pais[] tresPaises() {
		return dao.tresPaises();
	}
	
	public ArrayList<Pais> listarPaises() {
		return dao.listarPaises();
		
	}
	
	public boolean equals(Object obj) {
		return dao.equals(obj);
	}

}