package libreria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libros {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String autor;
	private String titulo;
	@ManyToOne
	@JoinColumn(name = "ideditorial")
	private Editorial editorial;
	
	private int ano_publicacion;
	private int paginas;
	private String isbn;
	private double pvp;
	private String categoria;
	
	public Libros() {
		
	}
	
	
	
	public Libros(String autor, String titulo, Editorial editorial, int ano_publicacion, int paginas,
			String isbn, double pvp, String categoria) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
		this.ano_publicacion = ano_publicacion;
		this.paginas = paginas;
		this.isbn = isbn;
		this.pvp = pvp;
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Libros [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial
				+ ", ano_publicacion=" + ano_publicacion + ", paginas=" + paginas + ", isbn=" + isbn + ", pvp=" + pvp
				+ ", categoria=" + categoria + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getAno_publicacion() {
		return ano_publicacion;
	}
	public void setAno_publicacion(int ano_publicacion) {
		this.ano_publicacion = ano_publicacion;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPvp() {
		return pvp;
	}
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
