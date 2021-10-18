package br.com.cotacao.fii.ws.statusinvest.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cotacao.fii.ws.statusinvest.dto.InformacaoFIIStatusinvestDTO;
import br.com.cotacao.fii.ws.statusinvest.dto.ListagemFIIStatusinvestDTO;
import br.com.cotacao.fii.ws.statusinvest.dto.ResultadoCotacaoFIIStatusinvestDTO;

@Service
public class StatusInvestService {

	@Value("${fii.ws.statusinvest.url.informacao}")
	private String ulrInformacaoFII;

	@Value("${fii.ws.statusinvest.url.listagem}")
	private String urlListagemFII;

	@Value("${fii.ws.statusinvest.url.cotacao}")
	private String urlCotacaoFII;

	public List<InformacaoFIIStatusinvestDTO> informacaoFII(final String codeFII) throws URISyntaxException {
		final RestTemplate rest = new RestTemplate();
		final URI uri = new URI(ulrInformacaoFII.concat(codeFII));
		final ResponseEntity<List<InformacaoFIIStatusinvestDTO>> response = rest.exchange(uri, HttpMethod.GET,
				prepareHeader(), new ParameterizedTypeReference<List<InformacaoFIIStatusinvestDTO>>() {
				});
		return response.getBody();
	}

	public List<ListagemFIIStatusinvestDTO> listagemFII() throws URISyntaxException {
		final RestTemplate rest = new RestTemplate();
		final URI uri = new URI(urlListagemFII);
		final ResponseEntity<List<ListagemFIIStatusinvestDTO>> response = rest.exchange(uri, HttpMethod.GET,
				prepareHeader(), new ParameterizedTypeReference<List<ListagemFIIStatusinvestDTO>>() {
				});
		return response.getBody();
	}

	public ResultadoCotacaoFIIStatusinvestDTO buscaCotacao(final String codeFII,
			final TipoCategoriaCotacaoEnum categoria) throws URISyntaxException {
		final RestTemplate rest = new RestTemplate();
		final String url = urlCotacaoFII.concat(codeFII).concat("&type=").concat(categoria.getCatetgoria().toString());
		final URI uri = new URI(url);

		final ResponseEntity<ResultadoCotacaoFIIStatusinvestDTO[]> response = rest.exchange(uri, HttpMethod.GET,
				prepareHeader(), ResultadoCotacaoFIIStatusinvestDTO[].class);

		return response.getBody()[0];
	}

	protected HttpEntity<String> prepareHeader() {
		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		return entity;
	}

}
