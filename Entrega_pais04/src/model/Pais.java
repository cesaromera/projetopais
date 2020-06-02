package model;

import java.io.Serializable;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	public Pais() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	@Override
	public String toString() {
		return "Paises [id= " + id + ", nome= " + nome + ", populacao= " + populacao + ", area= " + area + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais pais = (Pais) obj;
		Pais other = (Pais) obj;

		if (pais.getArea() == 0.0) {
			if (other.getArea() != 0.0)
				return false;
		}

		if (pais.getPopulacao() == 0) {
			if (other.getPopulacao() != 0)
				return false;
		}

		if (pais.getId() != other.getId())
			return false;

		return true;
	}


}