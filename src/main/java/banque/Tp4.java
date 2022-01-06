package banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import banque.entity.Adresse;
import banque.entity.Banque;
import banque.entity.Client;
import banque.entity.Compte;
import banque.entity.Operation;

public class Tp4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("tp4-pu");
			EntityManager em = emf.createEntityManager();
			
			Adresse adresse = new Adresse();
			adresse.setCodePostal(44800);
			adresse.setVille("Saint Herblain");

			Banque banque = new Banque();
			banque.setNom("Les Voleurs");

			Compte compte = new Compte();
			compte.setNumero("XXX000XXX");
			compte.setSolde(999999);
			
			Operation operation = new Operation();
			operation.setDate(LocalDate.now());
			operation.setMontant(100);
			operation.setMotif("Du fric !");
			
			operation.setCompte(compte);
			//compte.getOperations().add(operation);
			
			Client client = new Client();
			client.setBanque(banque);
			client.setAdresse(adresse);
			
			compte.setClient(client);
			//client.getComptes().add(compte);
			
			//compte.setClient(client);

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(operation);
			em.persist(banque);
			em.persist(compte);
			em.persist(client);
			
			tx.commit();

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
