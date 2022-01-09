package tp2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import tp2.entity.Livre;

public class Tp2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("bibliotheque-pu");

			EntityManager em = emf.createEntityManager();

			Livre livre1 = getLivreById(1,em);
			System.out.println(livre1);

			Livre livre2 = new Livre();
			livre2.setAuteur("Moi Même");
			livre2.setTitre("Ma vie, mon oeuvre");
			livre2.setId(6);

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(livre2);
			tx.commit();
			System.out.println(livre2);

			Livre livre3 = getLivreById(5, em);
			if(livre3 != null) {
				livre3.setTitre("Du plaisir dans la cuisine");
			}
			tx.begin();
			em.merge(livre3);
			tx.commit();
			System.out.println(livre3);

			Livre livre4 = getLivreByTitre("Guerre et paix", em);
			System.out.println(livre4);

			Livre livre5 = getLivreByAuteur("Emile Zola", em);
			System.out.println(livre5);
			
			Livre livre6 = getLivreByTitre("Ma vie, mon oeuvre", em);
			tx.begin();
			em.remove(livre6);
			tx.commit();
				
			for (Livre l :getLivres(em)) {
				System.out.println(l);
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

	public static Livre getLivreById(Integer id, EntityManager em) {
		return em.find(Livre.class, id);
	}

	public static Livre getLivreByTitre(String titre, EntityManager em){
		String request = "select l from Livre l where l.titre = :title";
		TypedQuery<Livre> query2 = em.createQuery(request,
				Livre.class);
		query2.setParameter("title", titre);
		return query2.getSingleResult(); // Pour un unique résultat, exception sinon
		/**
		String request = "select l from Livre l where l.titre = \'" + titre + "\'";
		TypedQuery<Livre> query2 = em.createQuery(request,
				Livre.class);
		return query2.getResultList().get(0);
		**/
	}
	
	public static Livre getLivreByAuteur(String auteur, EntityManager em){
		String request = "select l from Livre l where l.auteur = \'" + auteur + "\'";
		TypedQuery<Livre> query2 = em.createQuery(request,
				Livre.class);
		return query2.getResultList().get(0);
	}
	
	public static List<Livre> getLivres(EntityManager em){
		String request = "select l from Livre l";
		TypedQuery<Livre> query2 = em.createQuery(request,
				Livre.class);
		return query2.getResultList();
	}

}
