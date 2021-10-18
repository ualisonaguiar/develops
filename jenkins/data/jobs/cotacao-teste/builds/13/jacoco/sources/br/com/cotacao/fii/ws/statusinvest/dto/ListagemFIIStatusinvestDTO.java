package br.com.cotacao.fii.ws.statusinvest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ListagemFIIStatusinvestDTO {

	private String companyName;

	@JsonProperty("ticker")
	private String code;

	private String price;

	@JsonProperty("dy")
	private Float yield;

	@JsonProperty("p_vp")
	private Float pVp;

	@JsonProperty("liquidezmediadiaria")
	private Double liquidezMediaDiaria;

	@JsonProperty("numerocotistas")
	private Long numeroCotistas;

	private Double patrimonio;

}
