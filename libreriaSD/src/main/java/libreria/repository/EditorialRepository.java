package libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.model.Editorial;



public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	
	Editorial findByCif(String cif);
	Editorial findByNombre(String nombre);
	Editorial findByEmail(String email);
	List<Editorial> findAllByOrderByNombre();

}

