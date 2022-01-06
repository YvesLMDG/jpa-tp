package banque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private double solde;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {
		operations = new HashSet<Operation>();
	}

	public Integer getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public double getSolde() {
		return solde;
	}

	public Client getClient() {
		return client;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}
