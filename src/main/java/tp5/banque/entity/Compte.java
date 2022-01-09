package tp5.banque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="NUMERO")
	private String numero;
	@Column(name="SOLDE")
	private double solde;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {
		operations = new HashSet<Operation>();
		clients = new HashSet<Client>();
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

	public Set<Client> getClients() {
		return clients;
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

	public void setClient(Set<Client> clients) {
		this.clients = clients;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}
