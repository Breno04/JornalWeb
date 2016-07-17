package br.ufc.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao){
		manager.persist(secao);
	}
	
	public List<Secao> listar() {
		return manager.createQuery("select s from SECAO as s", Secao.class).getResultList();
	}

	public Secao recuperarSecao(Long id) {
		return manager.find(Secao.class, id);
	}
	
}
