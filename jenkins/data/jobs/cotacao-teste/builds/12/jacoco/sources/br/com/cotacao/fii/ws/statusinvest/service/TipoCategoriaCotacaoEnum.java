package br.com.cotacao.fii.ws.statusinvest.service;

import lombok.Getter;

@Getter
public enum TipoCategoriaCotacaoEnum {

	ATUAL(-1), CORRIDO_5_DIAS(0), CORRIDO_30_DIAS(1), CORRIDO_6_MESE(2), CORRIDO_1_ANO(3), CORRIDO_5_ANO(4);

	private Integer catetgoria;

	TipoCategoriaCotacaoEnum(final Integer catetgoria) {
		this.catetgoria = catetgoria;
	}
}
