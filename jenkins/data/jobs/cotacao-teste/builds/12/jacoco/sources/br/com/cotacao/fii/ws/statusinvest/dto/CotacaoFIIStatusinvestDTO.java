package br.com.cotacao.fii.ws.statusinvest.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CotacaoFIIStatusinvestDTO {

	private Double price;

	@JsonFormat(pattern = "dd/MM/yy HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime date;

}
