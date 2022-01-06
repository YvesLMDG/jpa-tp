package dev.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {

	@Id
	@Column(name="ID")
	private Integer id;

	@Column(name="NOM")
	private String nom;

	@Column(name="PRENOM")
	private String prenom;

	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;

	public Client() {
		emprunts = new  HashSet<Emprunt>();
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
