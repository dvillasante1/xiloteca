package com.xiloteca.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiloteca.common.exceptions.ServicioException;
import com.xiloteca.entities.Muestra;

public interface IServicioMuestra {
	
	//Paginacion
	Page<Muestra> encuentraPorNonmbrePaginaJPQL(Pageable pagina, String nombre) throws ServicioException; 
	Muestra conseguirMuestra(Integer idMuestra)  throws ServicioException;

}