package br.com.cotacao.ws;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cotacao.dto.ResultCotacaoDTO;

@Service
public class CotacaoBCService {

	@Value("${bancocentral.url}")
	private String urlServico;

	public ResultCotacaoDTO valorCotacaoPorData(final LocalDate data) throws URISyntaxException {
		final RestTemplate rest = new RestTemplate();
		final URI uri = new URI(
				urlServico.concat("'".concat(data.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"))).concat("'"))
						.concat("&$format=json"));
		final ResponseEntity<ResultCotacaoDTO> response = rest.exchange(uri, HttpMethod.GET,
				new HttpEntity<String>("parameters"), ResultCotacaoDTO.class);
		return response.getBody();
	}
}
