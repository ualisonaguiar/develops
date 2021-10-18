package br.com.cotacao.fii.dto;

import lombok.Data;

@Data
public class InformacaoFIIDTO {

	private String nome;
	private String code;
	private Double valorCota;
	private Double variacao;
	private Boolean variacaoUp;

}
