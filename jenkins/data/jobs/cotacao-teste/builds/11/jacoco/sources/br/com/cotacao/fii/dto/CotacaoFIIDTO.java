package br.com.cotacao.fii.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CotacaoFIIDTO {

	private Double valor;
	private LocalDateTime data;

}
