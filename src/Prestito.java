import java.io.Serializable;

public class Prestito implements Serializable{
	private String codice_fiscale;
	private String isbn;
	
	public Prestito(String codice_fiscale, String ibsn) {
		this.codice_fiscale = codice_fiscale;
		this.isbn = ibsn;
	}
	
	public Prestito(Prestito p) {
		this.codice_fiscale = p.codice_fiscale;
		this.isbn = p.isbn;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String ibsn) {
		this.isbn = ibsn;
	}
	
	public String toString () {
		return "Codice fiscale: " + this.codice_fiscale + ", codice ISBN " + this.isbn;
	}
}
