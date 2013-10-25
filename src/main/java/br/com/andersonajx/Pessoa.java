package br.com.andersonajx;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

public final class Pessoa {

	private final String nome;
	private final DateTime nascimento;

	public Pessoa(String nome, DateTime nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public Integer calcularIdade() {
		return DateTime.now().year().get() - nascimento.year().get();
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("Nome", nome).toString();
	}

}
