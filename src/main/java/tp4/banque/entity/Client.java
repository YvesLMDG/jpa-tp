package tp4.banque.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Banque banque;
	
	@OneToMany(mappedBy="client")
	Set<Compte> comptes;
	
	public Client() {
		comptes = new HashSet<Compte>();
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
