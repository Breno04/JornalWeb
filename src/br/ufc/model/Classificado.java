package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "CLASSIFICADO")
public class Classificado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASSIFICADO_ID", nullable = false)
	private Long classificadoId;

	@Column(name = "TITULO")
	private String tituloClassificado;

	@Column(name = "TEXTO")
	private String textoClassificado;

	@Column(name = "PRECO_INICIAL")
	private Double precoInicial;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "DATA_OFERTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOferta;

	@Column(name = "MELHOR_OFERTA")
	private Double melhorOferta;

	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USUARIO_ID")
	private Usuario usuario;

	@Column(name = "AUTOR_OFERTA")
	private Long autorOferta;

	@Column(name = "NOME_AUT_OFER")
	private String nomeAutorOferta;

	@Column(name = "ATIVO", updatable = true)
	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getAutorOferta() {
		return autorOferta;
	}

	public void setAutorOferta(Long autorOferta) {
		this.autorOferta = autorOferta;
	}

	public String getNomeAutorOferta() {
		return nomeAutorOferta;
	}

	public void setNomeAutorOferta(String nomeAutorOferta) {
		this.nomeAutorOferta = nomeAutorOferta;
	}

	public Long getClassificadoId() {
		return classificadoId;
	}

	public void setClassificadoId(Long classificadoId) {
		this.classificadoId = classificadoId;
	}

	public String getTituloClassificado() {
		return tituloClassificado;
	}

	public void setTituloClassificado(String tituloClassificado) {
		this.tituloClassificado = tituloClassificado;
	}

	public String getTextoClassificado() {
		return textoClassificado;
	}

	public void setTextoClassificado(String textoClassificado) {
		this.textoClassificado = textoClassificado;
	}

	public Double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Double getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(Double melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
