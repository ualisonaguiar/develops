package br.com.cotacao.rest.cotacao;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotacao.dto.ResultCotacaoDTO;
import br.com.cotacao.model.Requisicao;
import br.com.cotacao.moeda.service.CotacaoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/dolar")
public class CotacaoDolarRest {

	CotacaoService service;

	@GetMapping
	public ResultCotacaoDTO getValorAtual(
			@RequestParam(name = "data") @DateTimeFormat(iso = ISO.DATE) final LocalDate data)
			throws URISyntaxException {
		return service.valorCotacaoPorData(data);
	}

	@GetMapping("/listagem")
	public List<Requisicao> getListam(
			@RequestParam(name = "data", required = false) @DateTimeFormat(iso = ISO.DATE) final LocalDate data) {
		return service.listagemCotacao();
	}

}
