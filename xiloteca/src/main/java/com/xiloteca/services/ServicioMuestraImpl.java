package com.xiloteca.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xiloteca.common.exceptions.CodeError;
import com.xiloteca.common.exceptions.ServicioException;
import com.xiloteca.entities.Muestra;
import com.xiloteca.repositories.IRepositoryMuestra;
import com.xiloteca.services.interfaces.IServicioMuestra;

@Service
public class ServicioMuestraImpl implements IServicioMuestra {
	Logger log = LoggerFactory.getLogger(ServicioMuestraImpl.class);

	@Autowired
	IRepositoryMuestra repository;

	@Override
	public Page<Muestra> encuentraPorNonmbrePaginaJPQL(Pageable pagina, String nombre) throws ServicioException {
		log.info("[encuentraPorNameCientJPQL]");
		log.debug("nombre: " + nombre);
		
		Page<Muestra> muestras;
		
		try {
			muestras = repository.encuentraPorNombrePaginaJPQL(pagina, nombre);
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return muestras;
	}

	@Override
	public Muestra conseguirMuestra(Integer idMuestra) throws ServicioException {
		log.info("[conseguirMuestra]");
		log.debug("idMuestra: " + idMuestra);

		Muestra muestra=null;
		Optional<Muestra> muestraOp = null;

		try {
			muestraOp = repository.findById(idMuestra);
			if(!muestraOp.isPresent()) throw new ServicioException(CodeError.MUESTRA_NOT_FOUND);
			
			muestra = muestraOp.get();
			
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}

		return muestra;
	}

}
