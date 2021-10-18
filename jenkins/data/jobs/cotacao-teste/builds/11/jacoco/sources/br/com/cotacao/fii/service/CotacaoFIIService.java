package br.com.cotacao.fii.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotacao.fii.dto.CotacaoFIIDTO;
import br.com.cotacao.fii.ws.statusinvest.service.StatusInvestService;
import br.com.cotacao.fii.ws.statusinvest.service.TipoCategoriaCotacaoEnum;

@Service
public class CotacaoFIIService {

	@Autowired
	StatusInvestService statusInvestServiceWs;

	public List<CotacaoFIIDTO> cotacaoDia(final String codeFII) throws URISyntaxException {
		return statusInvestServiceWs.buscaCotacao(codeFII, TipoCategoriaCotacaoEnum.ATUAL).cotacoes();
	}

	public List<CotacaoFIIDTO> cotacao5Dia(final String codeFII) throws URISyntaxException {
		return statusInvestServiceWs.buscaCotacao(codeFII, TipoCategoriaCotacaoEnum.CORRIDO_5_DIAS).cotacoes();
	}

	public List<CotacaoFIIDTO> cotacao30Dia(final String codeFII) throws URISyntaxException {
		return statusInvestServiceWs.buscaCotacao(codeFII, TipoCategoriaCotacaoEnum.CORRIDO_30_DIAS).cotacoes();
	}
}
