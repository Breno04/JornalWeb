package br.ufc.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("jornal");
		fabrica.close();

	}
}
