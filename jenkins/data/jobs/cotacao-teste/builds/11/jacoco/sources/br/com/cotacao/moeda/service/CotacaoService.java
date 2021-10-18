package br.com.cotacao.moeda.service;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cotacao.dto.ResultCotacaoDTO;
import br.com.cotacao.model.Requisicao;
import br.com.cotacao.model.RequisicaoRepositoy;
import br.com.cotacao.ws.CotacaoBCService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CotacaoService {

	CotacaoBCService cotacaoService;
	RequisicaoRepositoy repository;

	public ResultCotacaoDTO valorCotacaoPorData(final LocalDate dtCotacao) throws URISyntaxException {
		final ResultCotacaoDTO valorCotacaoPorData = cotacaoService.valorCotacaoPorData(dtCotacao);

		valorCotacaoPorData.getContacao().stream().forEach(cotacao -> {
			final Requisicao requisicao = new Requisicao();
			requisicao.setDtCotacao(dtCotacao);
			requisicao.setDtHoraCotacao(cotacao.getDataHoraCotacao());
			requisicao.setDtRequisicao(LocalDateTime.now());
			requisicao.setVlCompra(cotacao.getCotacaoCompra());
			requisicao.setVlVenda(cotacao.getCotacaoVenda());
			repository.save(requisicao);
		});
		return valorCotacaoPorData;
	}

	public List<Requisicao> listagemCotacao() {
		return repository.findAll();
	}

	public List<Requisicao> listagemCotacao(final LocalDate dtCotacao) {
		return repository.listagemCotacaoPorData(dtCotacao);
	}

}
