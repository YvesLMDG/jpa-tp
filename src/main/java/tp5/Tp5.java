package tp5;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tp5.banque.entity.Adresse;
import tp5.banque.entity.AssuranceVie;
import tp5.banque.entity.Banque;
import tp5.banque.entity.Client;
import tp5.banque.entity.Compte;
import tp5.banque.entity.LivretA;
import tp5.banque.entity.Operation;
import tp5.banque.entity.Virement;


public class Tp5 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

			emf = Persistence.createEntityManagerFactory("tp5-pu");
			EntityManager em = emf.createEntityManager();
			
			Adresse adresseClientA = new Adresse();
			adresseClientA.setNumero(1);
			adresseClientA.setRue("rue Edith Plouf");
			adresseClientA.setCodePostal(44800);
			adresseClientA.setVille("Saint Herblain");
			
			Adresse adresseClientB = new Adresse();
			adresseClientB.setNumero(2);
			adresseClientB.setRue("rue Victor C\'est cher");
			adresseClientB.setCodePostal(44800);
			adresseClientB.setVille("Saint Herblain");

			Banque banque = new Banque();
			banque.setNom("Les Voleurs");

			Compte compte1 = new Compte();
			compte1.setNumero("XXX1111XXX");
			compte1.setSolde(1111);
			
			Client clientA = new Client();
			clientA.setNom("ClientA");
			clientA.setAdresse(adresseClientA);
			clientA.setBanque(banque);
			clientA.getComptes().add(compte1);
			
			Client clientB = new Client();
			clientB.setNom("ClientB");
			clientB.setAdresse(adresseClientB);
			clientB.setBanque(banque);
			clientB.getComptes().add(compte1);
	
			Operation operation = new Operation();
			operation.setDate(LocalDate.now());
			operation.setMontant(111);
			operation.setMotif("Du fric !");

			EntityTransaction tx1 = em.getTransaction();
			tx1.begin();
			em.persist(banque);
			em.persist(compte1);
			em.persist(clientA);
			em.persist(clientB);
			tx1.commit();
			
			Adresse adresseClientC = new Adresse();
			adresseClientC.setNumero(3);
			adresseClientC.setRue("bd Marcel et son Orchestre");
			adresseClientC.setCodePostal(44800);
			adresseClientC.setVille("Saint Herblain");
			
			Compte compte2 = new Compte();
			compte2.setNumero("XXX2222XXX");
			compte2.setSolde(2222);

			AssuranceVie assuranceVie1 = new AssuranceVie();
			assuranceVie1.setNumero("AV3333AV");
			assuranceVie1.setSolde(3333);
			assuranceVie1.setDateFin(LocalDate.of(2050, 1, 1));
			assuranceVie1.setTaux(8.0);
			
			LivretA livretA1 = new LivretA();
			livretA1.setNumero("LA4444LA");
			livretA1.setSolde(4444);
			livretA1.setTaux(1.0);
			
			Client clientC = new Client();
			clientC.setNom("clientC");
			clientC.setAdresse(adresseClientC);
			clientC.setBanque(banque);
			clientC.getComptes().add(assuranceVie1);
			clientC.getComptes().add(livretA1);
			
			EntityTransaction tx2 = em.getTransaction();
			tx2.begin();
			em.persist(clientC);
			em.persist(assuranceVie1);
			em.persist(livretA1);
			tx2.commit();
		
			Virement virement1 = new Virement();
			virement1.setBeneficiaire("DGFIP");
			virement1.setDate(LocalDate.now());
			virement1.setMotif("Faut bien raquer");
			virement1.setMontant(-2000.0);
			virement1.setCompte(compte1);
			compte1.setSolde(compte1.getSolde() + virement1.getMontant());
			
			Virement virement2 = new Virement();
			virement2.setBeneficiaire("EDF");
			virement2.setDate(LocalDate.now());
			virement2.setMotif("Et la lumière fut");
			virement2.setMontant(-60);
			virement2.setCompte(compte1);
			compte1.setSolde(compte1.getSolde() + virement2.getMontant());
			
			EntityTransaction tx3 = em.getTransaction();
			tx3.begin();
			em.persist(virement1);
			em.persist(virement2);
			em.merge(compte1);
			tx3.commit();
			
			Operation operation1 = new Operation();
			operation1.setDate(LocalDate.now());
			operation1.setMotif("Les soussous à Mémé pour Noël");
			operation1.setMontant(50);
			operation1.setCompte(livretA1);
			livretA1.setSolde(livretA1.getSolde() + operation1.getMontant());
			
			Operation operation2 = new Operation();
			operation2.setDate(LocalDate.now());
			operation2.setMotif("Les soussous à tonton gégé pour Noël");
			operation2.setMontant(25);
			operation2.setCompte(livretA1);
			livretA1.setSolde(livretA1.getSolde() + operation2.getMontant());
			
			EntityTransaction tx4 = em.getTransaction();
			tx4.begin();
			em.persist(operation1);
			em.persist(operation2);
			em.merge(livretA1);
			tx4.commit();
		
			em.close();
	}

}
