import java.io.Serializable;

public class Socio implements Serializable{
	private String codice_fiscale;
	private String nome;
	private String cognome;
	private String email;
	
	public Socio(String codice_fiscale, String nome, String cognome, String email) {
		this.codice_fiscale = codice_fiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	public Socio(Socio s) {
		this.codice_fiscale = s.codice_fiscale;
		this.nome = s.nome;
		this.cognome = s.cognome;
		this.email = s.email;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Codice fiscale: " + this.codice_fiscale + ", nome: " + this.nome + ", cognome: " + this.cognome + ", email: " + this.email; 
	}
}
