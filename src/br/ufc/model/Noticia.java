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

@Entity(name = "NOTICIA")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NOTICIA_ID", nullable = false)
	private Long noticiaId;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "SUBTITULO")
	private String subtitulo;

	@Column(name = "TEXTO", columnDefinition = "text")
	private String texto;

	@Column(name = "DATA_NOTICIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNoticia;

	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;

	@Column(name = "SECAO_ID", insertable = false, updatable = false, nullable = false)
	private Long secId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USUARIO_ID")
	private Usuario usuario;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SECAO_ID", referencedColumnName = "SECAO_ID")
	private Secao secao;

	@Column(name = "ATIVO", updatable = true)
	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public Long getSecId() {
		return secId;
	}

	public void setSecId(Long secId) {
		this.secId = secId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}
