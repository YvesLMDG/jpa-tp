package tp4.banque.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDate date;
	private double montant;
	private String motif;
	
	@ManyToOne
	private Compte compte;
	
	public Operation() {
		
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getMontant() {
		return montant;
	}

	public String getMotif() {
		return motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
