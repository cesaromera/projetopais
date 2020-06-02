package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Pais;
import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {

	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	static long populacao;
	static double area;
	static String nome;

	@Before
	public void setUp() throws Exception {
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Argentina");
		pais.setPopulacao(745454);
		pais.setArea(4324);

		copia = new Pais();
		copia.setId(id);
		copia.setNome("Argentina");
		copia.setPopulacao(745454);
		copia.setArea(4324);

		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void test00Carregar() {
		System.out.println("\nCarregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Inglaterra");
		fixture.setPopulacao(55619400);
		fixture.setArea(130395.0);
		PaisService newPaisService = new PaisService();
		Pais novo = newPaisService.carregar(1);
		assertEquals("Testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("\nCriar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("\nAtualizar");
		pais.setArea(9999);
		copia.setArea(9999);
		paisService.atualizar(pais);
		pais = paisService.carregar(copia.getId());
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("testa atualizacao", pais, copia);

	}

	@Test
	public void test03Excluir() {
		System.out.println("\nExcluir");
		copia.setId(0);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("testa exclusao", pais, copia);
	}

	@Test
	public void test04menorArea() {
		System.out.println("\nMenor Area");
		paisService.menorArea(pais);
		area = pais.getArea();
		copia.setArea(area);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa menor area", copia, pais);
	}

	@Test
	public void test05maiorPopulacao() {
		System.out.println("\nMaior População");
		paisService.maiorPopulacao(pais.getPopulacao());
		populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa maior populacao", copia, pais);
	}

	@Test
	public void test06tresPaises() {
		System.out.println("\nVetor 3 Paises");
		Pais[] vetor = paisService.tresPaises();
		for (Pais pais : vetor) {
			id = pais.getId();
			area = pais.getArea();
			nome = pais.getNome();
			populacao = pais.getPopulacao();
			copia.setId(id);
			copia.setArea(area);
			copia.setNome(nome);
			copia.setPopulacao(populacao);
			System.out.println(pais);
			System.out.println(copia);
			assertEquals("Testa vetor", copia, pais);
		}
	}
}