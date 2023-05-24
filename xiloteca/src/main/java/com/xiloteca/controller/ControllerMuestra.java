package com.xiloteca.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiloteca.common.Constantes;
import com.xiloteca.common.exceptions.CodeError;
import com.xiloteca.common.exceptions.ServicioException;
import com.xiloteca.entities.Muestra;
import com.xiloteca.services.ServicioMuestraImpl;
import com.xiloteca.services.interfaces.IServicioMuestra;

@Controller
@RequestMapping("/muestras")
public class ControllerMuestra {

	@Autowired
	IServicioMuestra servicio;

	Logger log = LoggerFactory.getLogger(ServicioMuestraImpl.class);

	@GetMapping
	public Page<Muestra> verMuestraCient(@RequestParam int page, @RequestParam String nombre, Model model)
			throws Exception {

		Page<Muestra> muestras = servicio
				.encuentraPorNonmbrePaginaJPQL(PageRequest.of(page - 1, Constantes.NUM_REGISTROS_PAGINACION), nombre);
		model.addAttribute("muestras", muestras);
		model.addAttribute("nombre", nombre.toUpperCase());

		long totalResultados = muestras.getTotalElements();
		model.addAttribute("totalResultados", totalResultados);

		devolverPaginacion(model, muestras);

		return muestras;

	}

	private void devolverPaginacion(Model model, Page<Muestra> muestras) {
		int totalPages = muestras.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
	}

	@GetMapping("/{id}")
	public String conseguirMuestra(@PathVariable Integer id, Model model) throws Exception {

		Muestra muestra = null;

		muestra = servicio.conseguirMuestra(id);
		model.addAttribute("muestra", muestra);

		devolverImagesJB(model, muestra);

		return "muestra";
	}

	private void devolverImagesJB(Model model, Muestra muestra) {

		List<String> _lab = new ArrayList<>();
		int contador = 1;
		boolean control = false;

		do {
			String nombreFichero = muestra.getId_muestra() + "_lab_" + contador + ".jpg";
			String RutaArchivo = new File(".").getAbsolutePath() + Constantes.DIRECTORIO_FICHEROS_IMAGENES + nombreFichero;
			
			Path path = Paths.get(RutaArchivo);
			control = Files.exists(path);
			
			if (control) {
				_lab.add(nombreFichero);
				control = true;
				contador++;
			} else {
				control = false;
			}
		} while (control);

		model.addAttribute("imagenes_lab", _lab);
	}

	@ExceptionHandler({ ServicioException.class, Exception.class })
	public String handleException(Exception e, Model model) {

		if (e instanceof ServicioException) {
			model.addAttribute("keyError", ((ServicioException) e).getCodigo());
		} else {
			model.addAttribute("keyError", CodeError.ERROR_GENERAL);
		}

		return "error";
	}
}
