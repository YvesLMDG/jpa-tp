package tp5.banque.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="NOM")
	private String nom;
	@Column(name="DATE_NAISSANCE")
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;

	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",
	joinColumns=@JoinColumn(name="ID_CLIENT", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_COMPTE", referencedColumnName="ID")
			)
	private Set<Compte> comptes;

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
