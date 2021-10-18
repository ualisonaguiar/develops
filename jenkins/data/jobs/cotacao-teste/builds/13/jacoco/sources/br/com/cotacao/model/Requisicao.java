package br.com.cotacao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_requisicao")
public class Requisicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_requisicao")
	private Long idRequisicao;

	@NotNull
	@Column(name = "dt_requisicao")
	private LocalDateTime dtRequisicao;

	@NotNull
	@Column(name = "dt_cotacao")
	private LocalDate dtCotacao;

	@NotNull
	@Column(name = "vl_compra")
	private Float vlCompra;

	@NotNull
	@Column(name = "vl_venda")
	private Float vlVenda;

	@NotNull
	@Column(name = "dt_hora_cotacao")
	private String dtHoraCotacao;

}
