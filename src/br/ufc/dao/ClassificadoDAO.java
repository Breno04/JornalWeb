package br.ufc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirClassificado(Classificado classificado){
		this.manager.persist(classificado);
	}
	
	public Classificado recuperarClassificado(Long id){
		return manager.find(Classificado.class, id);
	}
	
	public List<Classificado> mostrarClassificado(Long claId){
		
		String hql = "select c from CLASSIFICADO as c "
				+ "where c.classificadoId = :param_classificadoId";
		
		Query query =  manager.createQuery(hql);
		List<Classificado> classificados = query.setParameter("param_classificadoId", claId).getResultList();
		
		
			return classificados;
		
	}
	
	public List<Classificado> mostrarMancheteClassificado(){
		return manager.createQuery("select c from CLASSIFICADO as c", Classificado.class).getResultList();
	}
	
	public void alterarClassificado(Classificado classificado){
		Date date = new Date();
		classificado.setDataOferta(date);
		this.manager.merge(classificado);
	}
	
	public List<Classificado> classificadosRecentes(){
		return this.manager.createQuery("select c from CLASSIFICADO as c order by c.classificadoId desc", Classificado.class).getResultList();
	}

}
