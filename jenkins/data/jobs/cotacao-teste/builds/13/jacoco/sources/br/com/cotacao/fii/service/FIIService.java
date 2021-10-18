package br.com.cotacao.fii.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotacao.fii.dto.InformacaoFIIDTO;
import br.com.cotacao.fii.ws.statusinvest.dto.InformacaoFIIStatusinvestDTO;
import br.com.cotacao.fii.ws.statusinvest.dto.ListagemFIIStatusinvestDTO;
import br.com.cotacao.fii.ws.statusinvest.service.StatusInvestService;

@Service
public class FIIService {

	@Autowired
	StatusInvestService statusInvestServiceWs;

	public InformacaoFIIDTO informacao(final String codeFII) throws URISyntaxException {
		final List<InformacaoFIIStatusinvestDTO> informacaoFII = statusInvestServiceWs.informacaoFII(codeFII);
		if (informacaoFII.isEmpty()) {
			return new InformacaoFIIDTO();
		}
		return informacaoFII.get(0).getResult();
	}

	public List<ListagemFIIStatusinvestDTO> listagem() throws URISyntaxException {
		return statusInvestServiceWs.listagemFII();
	}

}
