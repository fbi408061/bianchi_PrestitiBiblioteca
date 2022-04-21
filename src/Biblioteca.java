
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Biblioteca {
	private HashMap<String, Libro> libri;
	private TreeMap<String, Socio> soci;
	private ArrayList<Prestito> prestiti;
	
	public Biblioteca() {
		this.libri = new HashMap<>();
		this.soci = new TreeMap<>();
		this.prestiti = new ArrayList<>();
	}
	
	public void aggiungiLibro(Libro l) {
		if (!this.soci.containsKey(l.getIsbn()))
			this.libri.put(l.getIsbn(), new Libro(l));
	}
	
	public void aggiungiSocio(Socio s) {
		if (!this.soci.containsKey(s.getCodice_fiscale()))
			this.soci.put(s.getCodice_fiscale(), new Socio(s));
	}
	
	public Libro cercaLibro(String isbn) {
		return this.libri.get(isbn);
	}
	
	public Socio cercaDatiSocio(String codice_fiscale) {
		return this.soci.get(codice_fiscale);
	}
	
	public Socio verificaPrestito(String isbn) {
		int i = 0;
		for (Prestito p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn)) {
				return this.soci.get(p.getCodice_fiscale());
			}
			i++;
		}
		return null;
	}
	
	public void memorizzaPrestito (Prestito p) {
		if (verificaPrestito(p.getIsbn()) == null) 
			this.prestiti.add(new Prestito(p));
	}
	
	public boolean aggiornaPrestiti (String isbn) {
		for (Prestito p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn)) {
				this.prestiti.remove(p);
				return true;
			}
		}
		return false;
	}
	
	public void salvaLibri() {
		ObjectOutputStream oos_l = null; 
		try {
			oos_l = new ObjectOutputStream(new FileOutputStream("file_libri.bin"));
			oos_l.writeObject(this.libri);
			oos_l.close();
			System.out.println("Dati salvati nel file file_libri.bin");
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file");
		}
		
	}
	
	public void salvaSoci() {
		ObjectOutputStream oos_s = null; 
		try {
			oos_s = new ObjectOutputStream(new FileOutputStream("file_soci.bin"));
			oos_s.writeObject(this.soci);
			oos_s.close();
			System.out.println("Dati salvati nel file file_soci.bin");
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file");
		}
	}

	public void salvaPrestiti() {
		ObjectOutputStream oos_p = null; 
		try {
			oos_p = new ObjectOutputStream(new FileOutputStream("file_prestiti.bin"));
			oos_p.writeObject(this.prestiti);
			oos_p.close();
			System.out.println("Dati salvati nel file file_prestiti.bin");
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file");
		}
	}
	
	public void caricaLibri() {
		ObjectInputStream ois_l = null;
		try {
			ois_l = new ObjectInputStream(new FileInputStream("file_libri.bin"));
			this.libri = (HashMap<String, Libro>) ois_l.readObject();
			ois_l.close();
			System.out.println("Lettura dati dal file file_libri.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}
	
	public void caricaSoci() {
		ObjectInputStream ois_s = null;
		try {
			ois_s = new ObjectInputStream(new FileInputStream("file_soci.bin"));
			this.soci = (TreeMap<String, Socio>) ois_s.readObject();
			ois_s.close();
			System.out.println("Lettura dati dal file file_soci.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}
	
	public void caricaPrestiti() {
		ObjectInputStream ois_p = null;
		try {
			ois_p = new ObjectInputStream(new FileInputStream("file_prestiti.bin"));
			this.prestiti = (ArrayList<Prestito>) ois_p.readObject();
			ois_p.close();
			System.out.println("Lettura dati dal file file_prestiti.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}
	
	public String stampaPrestiti() {
		String out = "";
		for (Prestito p  : this.prestiti) {
			out += (p.toString()+ "\n");
		}
		return out;
	}
	
	public String stampaLibri() {
		String out = "";
		for (String key : this.libri.keySet()) {
			out += (this.libri.get(key).toString()+ "\n");
		}
		return out;
	}
	
	public String stampaSoci() {
		String out = "";
		for (String key : this.soci.keySet()) {
			out += (this.soci.get(key).toString() + "\n");
		}
		return out;
	}
}
