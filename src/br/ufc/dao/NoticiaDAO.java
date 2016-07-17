package br.ufc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;

@Repository
public class NoticiaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserirNoticia(Noticia noticia) {
		Date date = new Date();
		noticia.setDataNoticia(date);

		this.manager.persist(noticia);
	}

	public Noticia recuperarNoticia(Long id) {
		return manager.find(Noticia.class, id);
	}

	public void alterarNoticia(Noticia noticia) {
		this.manager.merge(noticia);
	}

	public List<Noticia> mostrarNoticia(Long noId) {

		String hql = "select n from NOTICIA as n "
				+ "where n.noticiaId = :param_noticiaId";

		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("param_noticiaId", noId)
				.getResultList();

		return noticias;

	}

	public List<Noticia> mostrarManchete(Long secaoId) {
		String hql = "select n from NOTICIA as n "
				+ "where n.ativo = 1 AND n.secId = :param_secaoId";

		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("param_secaoId", secaoId)
				.getResultList();

		return noticias;
	}

	public List<Noticia> mostrarNoticiaJornalista(Long usuarioId) {
		String hql = "select n from NOTICIA as n "
				+ "where n.ativo = 1 AND n.usuId = :param_usuarioId";

		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("param_usuarioId",
				usuarioId).getResultList();

		return noticias;
	}

	public List<Noticia> destaques() {
		
		return manager
				.createQuery(
						"select n from NOTICIA as n where n.ativo = 1 order by n.dataNoticia desc",
						Noticia.class).getResultList();
	}

}
