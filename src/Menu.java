
public class Menu {
	static Input in = new Input();
	public static int menu() {
		int scelta;
		scelta = in.inputInt("[1]Cerca un libro dato il codice isbn\n" + "[2]Cerca un socio dato il suo codice fiscale\n" +
					"[3]Verifica se un libro è stato prestato\n" + "[4]Memorizza prestito\n" + "[5]Rimuovi un libro dalla lista prestiti\n" +
						 "[6]Aggiungi libro\n" + "[7]Aggiungi socio\n" +   "[8]Stampa libri\n" + "[9]Stampa soci\n" + 
						 	"[10]Stampa prestiti\n" + "[11]Esci\n" +  "Cosa vuoi fare?");
		return scelta;
	}
	
	public static void cercaLibro(Biblioteca b) {
		String isbn = in.inputString("Codice ISBN del libro: ", 13);
		if(b.cercaLibro(isbn) != null) {
			System.out.println(b.cercaLibro(isbn).toString());
		}else {
			System.out.println("Libro non trovato");
		}
	}
	
	public static void cercaDatiSocio(Biblioteca b) {
		String codice_fiscale = in.inputString("Codice fiscale del socio: ", 16);
		if(b.cercaDatiSocio(codice_fiscale) != null) {
			System.out.println(b.cercaDatiSocio(codice_fiscale).toString());
		}else {
			System.out.println("Socio non trovato");
		}
	}	
	
	public static void verificaPrestito(Biblioteca b) {
		String isbn = in.inputString("Codice ISBN del libro: ", 13);
		if(b.verificaPrestito(isbn) != null) {
			System.out.println("Il libro: " + b.cercaLibro(isbn).toString() + " è stato prestato a: " + b.verificaPrestito(isbn));
		}else {
			System.out.println("Prestito non trovato");
		}
	}	
	
	public static void aggiungiPrestito(Biblioteca b) {
		String codice_fiscale = in.inputString("Codice fiscale del socio: ", 16);
		String isbn = in.inputString("Codice ISBN del libro: ", 13);
		b.memorizzaPrestito(new Prestito(codice_fiscale, isbn));
	}	
	
	public static void aggiornaPrestiti(Biblioteca b) {
		String isbn = in.inputString("Codice ISBN del libro: ", 13);
		if(b.aggiornaPrestiti(isbn)) {
			System.out.println("Libro: " + b.cercaLibro(isbn).toString() + " resituito.");
		}else {
			System.out.println("Libro non in prestito");
		}
	}	
	
	public static void aggiungiLibro(Biblioteca b) {
		String isbn = in.inputString("Codice ISBN del libro: ", 13);
		String nome = in.inputString("Nome: ");
		String autore = in.inputString("Autore: ");
		b.aggiungiLibro(new Libro(isbn, nome, autore));
	}	
	
	public static void aggiungiSocio(Biblioteca b) {
		String codice_fiscale = in.inputString("Codice fiscale: ", 16);
		String nome = in.inputString("Nome: ");
		String cognome = in.inputString("Cognome: ");
		String email = in.inputString("Email: ");
		b.aggiungiSocio(new Socio(codice_fiscale, nome, cognome, email));
	}	
	
	public static void main(String[] args) {
		int ris;
		Biblioteca b = new Biblioteca();
		b.caricaPrestiti();
		b.caricaLibri();
		b.caricaSoci();
		do {
			System.out.println();
			ris = menu();
			System.out.println();
			switch (ris) {
			case 1:
				cercaLibro(b);
				break;
			
			case 2:
				cercaDatiSocio(b);
				break;
			
			case 3:
				verificaPrestito(b);
				break;
				
			case 4:
				aggiungiPrestito(b);
				break;
			
			case 5:
				aggiornaPrestiti(b);
				break;
				
			case 6:
				aggiungiLibro(b);
				break;
				
			case 7:
				aggiungiSocio(b);
				break;
				
			case 8:
				System.out.println(b.stampaLibri());
				break;
				
			case 9:
				System.out.println(b.stampaSoci());
				break;
				
			case 10:
				System.out.println(b.stampaPrestiti());
				break;
				
			case 11:
				b.salvaLibri();
				b.salvaPrestiti();
				b.salvaSoci();
				break;
				
			default:
				System.out.println("Operazione inesistente");
				break;
			}
		}while(ris != 11);
	}
}
