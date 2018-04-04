package libreria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;



@Entity
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ideditorial;
	
	private String nombre;
	private long telefono;

	private String email;
	private String direccion;
	private String cif;
	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	
	
	@OneToMany(mappedBy = "editorial")
	private List<Libros> libros;
	
	public Editorial() {
	
	}

	public Editorial(String nombre, long telefono, String email, String direccion, String cif) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.cif = cif;
	}

	@Override
	public String toString() {
		return "Editorial [ideditorial=" + ideditorial + ", nombre=" + nombre + ", telefono=" + telefono + ", email="
				+ email + ", direccion=" + direccion + ", libros=" + libros + "]";
	}

	public long getIdeditorial() {
		return ideditorial;
	}

	public void setIdeditorial(long ideditorial) {
		this.ideditorial = ideditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libros> getLibros() {
		return libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}
	
	
	
}
