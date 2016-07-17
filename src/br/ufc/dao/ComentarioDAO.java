package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

@Repository
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager maneger;

	public void inserirComentario(Comentario comentario) {
		this.maneger.persist(comentario);
	}

	public void alterarComentario(Comentario comentario) {
		this.maneger.merge(comentario);
	}

	public List<Comentario> listarComentario(Long idNoticia) {

		String hql = "select c from COMENTARIO as c "
				+ "where c.ativo = 1 AND c.noticiaId = :param_noticiaId order by id desc";
		Query query = maneger.createQuery(hql);
		List<Comentario> comentarios = query.setParameter("param_noticiaId",
				idNoticia).getResultList();

		return comentarios;

	}

	public Comentario recuperarComentario(Long comenatrioId) {
		return this.maneger.find(Comentario.class, comenatrioId);
	}

}
