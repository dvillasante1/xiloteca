package com.xiloteca.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiloteca.entities.Muestra;

public interface IRepositoryMuestra extends JpaRepository<Muestra, Integer> {

	 /*JPQL*/	 	 
	 @Query(value="SELECT m FROM Muestra m WHERE m.cient_acept1 LIKE %:nombre% "
			 								+"OR m.vulgar LIKE %:nombre% "
			 								+"ORDER BY cient_acept1")
	 Page<Muestra> encuentraPorNombrePaginaJPQL(Pageable pagina, @Param("nombre") String miNombre);
}