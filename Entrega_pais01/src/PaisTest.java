import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {

	Pais pais, copia;
	static int id = 0;
	static long populacao;
	static double area;
	static String nome;

	@Before
	public void setUp() throws Exception {
		pais = new Pais(id, "Argentina", 745454, 4324);
		copia = new Pais(id, "Argentina", 745454, 4324);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void test00Carregar() {
		System.out.println("\nCarregar");
		Pais fixture = new Pais(1, "Inglaterra",  55619400, 130395.00);
		Pais novo = new Pais(1, "Inglaterra",  55619400, 130395.00);
		novo.carregar();
		assertEquals("Testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("\nCriar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("\nAtualizar");
		pais.setId(1);
		copia.setId(1);
		pais.setArea(9999);
		copia.setArea(9999);
		pais.atualizar();
		pais.carregar();
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa atualizacao", pais, copia);

	}

	@Test
	public void test03Excluir() {
		System.out.println("\nExcluir");
		copia.setId(0);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa exclusao", pais, copia);
	}

	@Test
	public void test04menorArea() {
		System.out.println("\nMenor Area");
		pais.menorArea();
		area = pais.getArea();
		copia.setArea(area);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa menor area", copia, pais);
	}

	@Test
	public void test05maiorPopulacao() {
		System.out.println("\nMaiorPopulação");
		pais.maiorPopulacao();
		populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		System.out.println(pais);
		System.out.println(copia);
		assertEquals("Testa maior populacao", copia, pais);
	}

	@Test
	public void test06tresPaises() {
		System.out.println("\nVetor 3 Paises");
		Pais[] vetor = Pais.tresPaises();
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