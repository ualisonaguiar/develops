package br.com.cotacao.fii.ws.statusinvest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.cotacao.fii.dto.InformacaoFIIDTO;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class InformacaoFIIStatusinvestDTO {

	private String nameFormated;
	private String name;
	private String normalizedName;
	private String code;
	private String price;
	private String variation;
	private Boolean variationUp;

	public InformacaoFIIDTO getResult() {
		final InformacaoFIIDTO fii = new InformacaoFIIDTO();
		fii.setCode(getCode());
		fii.setNome(getName());
		fii.setValorCota(new Double(getPrice()));
		fii.setVariacao(new Double(getVariation()));
		fii.setVariacaoUp(getVariationUp());
		return fii;
	}

	public void setPrice(final String price) {
		this.price = price.replace(",", ".");
	}

	public void setVariation(final String variation) {
		this.variation = variation.replace(",", ".");
	}

}
