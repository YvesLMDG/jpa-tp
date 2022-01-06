package dev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import dev.entity.Client;
import dev.entity.Emprunt;
import dev.entity.Livre;

public class Tp3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("tp3-pu");
			EntityManager em = emf.createEntityManager();
			
			Emprunt emprunt = em.find(Emprunt.class, 4);
			
			for(Livre l: emprunt.getLivres()) {
				System.out.println(l);
			}
			
			Client client = em.find(Client.class, 1);
			for(Emprunt e: client.getEmprunts()) {
				System.out.println(e);
			}
			
			em.close();
		} 
		catch (PersistenceException e) {
			System.err.println("Erreur de persistance : " + e.getMessage());
		}

		finally {
			if (emf != null) {
				emf.close();
			}
		}
	}

}
