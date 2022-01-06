package banque.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private Integer numero;
	private String rue;
	private Integer codePostal;
	private String ville;
	
	public Adresse() {
		
	}

	public Integer getNumero() {
		return numero;
	}

	public String getRue() {
		return rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
