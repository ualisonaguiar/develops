package br.com.cotacao.rest.fii;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotacao.fii.dto.InformacaoFIIDTO;
import br.com.cotacao.fii.service.FIIService;
import br.com.cotacao.fii.ws.statusinvest.dto.ListagemFIIStatusinvestDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/fii")
public class FIIRest {

	@Autowired
	FIIService service;

	@GetMapping(value = "/informacao")
	public InformacaoFIIDTO informacao(@RequestParam(name = "codigo") final String codigoFII)
			throws URISyntaxException {
		return service.informacao(codigoFII);
	}

	@GetMapping(value = "/listagem")
	public List<ListagemFIIStatusinvestDTO> listagem() throws URISyntaxException {
		return service.listagem();
	}

}
