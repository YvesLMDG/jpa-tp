package tp5.banque.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(name="NUMERO")
	private Integer numero;
	@Column(name="RUE")
	private String rue;
	@Column(name="CODE_POSTAL")
	private Integer codePostal;
	@Column(name="VILLE")
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
