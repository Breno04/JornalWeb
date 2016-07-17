package br.ufc.model;

import java.util.Collection;  
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USUARIO_ID", nullable = false)
	private Long usuarioId;

	@Column(name = "NOME")
	private String nomeCompleto;

	@Column(name = "LOGIN", nullable = false)
	private String login;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name="ATIVO",columnDefinition = "int default 1", updatable=true)
	private Boolean ativo;

	@OneToMany(mappedBy = "usuario", targetEntity = Classificado.class, fetch = FetchType.EAGER)
	private Collection<Classificado> classificados;

	@OneToMany(mappedBy = "usuario", targetEntity = Noticia.class, fetch = FetchType.EAGER)
	private Collection<Noticia> noticias;

	@OneToMany(mappedBy = "usuario", targetEntity = Comentario.class, fetch = FetchType.EAGER)
	private Collection<Comentario> comentario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_PAPEL", joinColumns = @JoinColumn(name = "USU_ID", referencedColumnName = "USUARIO_ID"), inverseJoinColumns = @JoinColumn(name = "PAPEL_ID", referencedColumnName = "PAPEL_ID"))
	private List<Papel> papelList;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(Collection<Classificado> classificados) {
		this.classificados = classificados;
	}

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Collection<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(Collection<Comentario> comentario) {
		this.comentario = comentario;
	}

	public List<Papel> getPapelList() {
		return papelList;
	}

	public void setPapelList(List<Papel> papelList) {
		this.papelList = papelList;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Usuario)) {
			return false;
		}

		Usuario ref = (Usuario) obj;
		if (ref.getUsuarioId() == this.usuarioId) {
			return true;
		}
		return false;
	}


}
