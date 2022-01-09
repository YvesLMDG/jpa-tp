package tp4.banque.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;
	
	public Banque() {
		
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
