package tp5.banque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BANQUE")
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="NOM")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;
	
	public Banque() {
		clients= new HashSet<Client>();
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
}
