package br.com.cotacao.fii.ws.statusinvest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.cotacao.fii.dto.CotacaoFIIDTO;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResultadoCotacaoFIIStatusinvestDTO {

	private List<CotacaoFIIStatusinvestDTO> prices;

	public List<CotacaoFIIDTO> cotacoes() {
		final List<CotacaoFIIDTO> ListCotacaoFII = new ArrayList<CotacaoFIIDTO>();
		getPrices().stream().forEach(cotacao -> {
			final CotacaoFIIDTO cotacaoDTO = new CotacaoFIIDTO();
			cotacaoDTO.setData(cotacao.getDate());
			cotacaoDTO.setValor(cotacao.getPrice());
			ListCotacaoFII.add(cotacaoDTO);
		});
		return ListCotacaoFII;
	}
}
