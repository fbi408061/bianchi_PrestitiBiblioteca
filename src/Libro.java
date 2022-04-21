import java.io.Serializable;

public class Libro implements Serializable{
	private String isbn;
	private String nome;
	private String autore;
	
	public Libro(String ibsn, String nome, String autore) {
		this.isbn = ibsn;
		this.nome = nome;
		this.autore = autore;
	}
	
	public Libro(Libro l) {
		this.isbn = l.isbn;
		this.nome = l.nome;
		this.autore = l.autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String ibsn) {
		this.isbn = ibsn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	public String toString() {
		return  "Codice ISBN: " + this.isbn + ", nome: " + this.nome + ", autore: " + this.autore;
	}
}
