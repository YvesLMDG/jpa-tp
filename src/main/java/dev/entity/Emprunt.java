package dev.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="DATE_DEBUT")
	private LocalDateTime dateDebut;
	
	@Column(name="DATE_FIN")
	private LocalDateTime dateFin;
	
	@Column(name ="DELAI")
	private Integer delay;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;

	public Emprunt() {
		livres = new HashSet<Livre>();
	}
	
	@Override
	public String toString() {
		String stringLivres = "";
		for(Livre l: livres) {
			stringLivres += String.format("%s\n",l.toString()); 
		}
		return String.format("EMPRUNT => id: %d, dateDebut: %s, dateFin: %s, client: %s %s \n%s",
				id, dateDebut, dateFin, client.getPrenom(), client.getNom(), stringLivres);
	}
	
	public Integer getId() {
		return id;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public Integer getDelay() {
		return delay;
	}

	public Client getClient() {
		return client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
