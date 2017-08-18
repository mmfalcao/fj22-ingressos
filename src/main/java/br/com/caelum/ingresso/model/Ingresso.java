package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	private Lugar lugar;
	
	public Lugar getLugar() {
		return lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @deprecated hibernate only
	 * */
	public Ingresso() {
		
	}
	
	public Ingresso(Sessao sessao, Desconto tipoDeDesconto, Lugar lugar) {
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
		this.lugar = lugar;
	}
}