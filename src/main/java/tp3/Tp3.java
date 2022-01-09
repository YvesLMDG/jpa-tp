package tp3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import tp3.entity.Client;
import tp3.entity.Emprunt;
import tp3.entity.Livre;

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
