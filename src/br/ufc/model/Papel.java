package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "PAPEL")
public class Papel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAPEL_ID", nullable = false)
	private Long id;

	@Column(name = "PAPEL")
	private String papel;

	@ManyToMany(mappedBy = "papelList", fetch = FetchType.EAGER)
	private List<Usuario> usuarioList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}
