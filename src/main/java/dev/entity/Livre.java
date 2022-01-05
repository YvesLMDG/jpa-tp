package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "AUTEUR")
	private String auteur;
	
	public Livre() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, Titre: %s, Auteur: %s", this.id, this.titre, this.auteur);
	}

}
