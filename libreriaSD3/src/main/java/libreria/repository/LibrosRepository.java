package libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.model.Libros;


public interface LibrosRepository extends JpaRepository<Libros, Long>{

	Libros findByisbn(String isbn);
	List<Libros> findByTitulo(String titulo);
	List<Libros> findByAutorAndCategoria(String autor, String categoria);
	List<Libros> findByAutor(String autor);
	List<Libros> findByCategoria(String categoria);

}
