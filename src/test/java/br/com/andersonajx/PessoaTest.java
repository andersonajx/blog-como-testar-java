package br.com.andersonajx;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class PessoaTest {

	@Test
	public void instanciacao() {
		DateTimeUtils.setCurrentMillisFixed(new DateTime(2013, 10, 1, 0, 0, 0).getMillis());

		Pessoa pessoa1 = new Pessoa("Fulano da Silva", DateTime.now());
		Pessoa pessoa2 = new Pessoa("Sicrano da Silva", DateTime.now());

		assertFalse(pessoa1.equals(pessoa2));

		Pessoa pessoa3 = new Pessoa("Sicrano da Silva", DateTime.now());

		assertFalse(pessoa2.equals(pessoa3));
	}

	@Test
	public void exibirToString() {
		Pessoa pessoa = new Pessoa("Sicrano da Silva", DateTime.now());
		assertEquals("Pessoa{Nome=Sicrano da Silva}", pessoa.toString());
	}

	@Test(expected = NullPointerException.class)
	public void calcularIdadeComNascimentoNulo() {
		new Pessoa("Fulano da Silva", null).calcularIdade();
	}

	@Test
	public void calcularIdadeComNascimentoInvalido() {
		DateTimeUtils.setCurrentMillisFixed(new DateTime(2013, 10, 1, 0, 0, 0).getMillis());

		Pessoa pessoa = new Pessoa("Fulano da Silva", new DateTime(2030, 4, 3, 0, 0, 0));

		Integer idade = pessoa.calcularIdade();

		assertNotNull(idade);
		assertTrue(idade == -17);
	}

	@Test
	public void calcularIdade() {
		DateTimeUtils.setCurrentMillisFixed(new DateTime(2013, 10, 1, 0, 0, 0).getMillis());

		Pessoa pessoa = new Pessoa("Fulano da Silva", new DateTime(1990, 4, 3, 0, 0, 0));

		Integer idade = pessoa.calcularIdade();

		assertNotNull(idade);
		assertTrue(idade == 23);
	}

}
