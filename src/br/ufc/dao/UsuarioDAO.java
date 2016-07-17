package br.ufc.dao;

import java.util.ArrayList;  
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;


	public void inserirUsuario(Usuario usuario, Papel papel) {

		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapelList(papeis);

		manager.persist(usuario);

	}
	

	public void alterarUsuario(Usuario usuario) {
		manager.merge(usuario);
	}

	public Usuario recuperarUsuario(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void apagarUsuario(Long id) {
		Usuario u = manager.find(Usuario.class, id);

		if (u != null) {
			manager.remove(u);
		}
	}

	public List<Usuario> listar() {
		return manager.createQuery("select u from USUARIO as u "
				+ "where u.ativo = 1", Usuario.class).getResultList();
	}

	public Usuario recuperarUsuario(String login) {
		String hql = "select u from USUARIO as u "
				+ "where u.login = :param_login";

		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("param_login", login)
				.getResultList();

		if (usuarios.size() != 0) {
			return usuarios.get(0);
		}

		return null;
	}

	public Long recuperarPapel(String papel) {
		String hql = "select p from PAPEL as p "
				+ "where papel = :param_papel";

		Query query = manager.createQuery(hql);
		List<Papel> papeis = query.setParameter("param_papel", papel)
				.getResultList();

		if (papeis.size() != 0) {
			Papel p = papeis.get(0);
			return p.getId();
		}

		return null;
	}
}
