package libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.model.Editorial;



public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	
	Editorial findByCif(String cif);
	
	List<Editorial> findAllByOrderByNombre();

}

