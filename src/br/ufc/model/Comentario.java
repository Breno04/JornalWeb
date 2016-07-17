package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "COMENTARIO")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMENTARIO_ID")
	private Long id;

	@Column(name = "TEXTO")
	private String texto;

	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USUARIO_ID")
	private Usuario usuario;

	@Column(name = "NOTICIA_ID", insertable = false, updatable = false, nullable = false)
	private Long noticiaId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "NOTICIA_ID", referencedColumnName = "NOTICIA_ID")
	private Noticia noticia;

	@Column(name = "ATIVO", updatable = true)
	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

}