package br.ufc.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Papel recuperarPapel(Long id) {
		return manager.find(Papel.class, id);
	}
	
	public List<Papel> listar() {
		return manager.createQuery("select p from PAPEL as p", Papel.class).getResultList();
	}

}
