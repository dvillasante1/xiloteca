package com.xiloteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/localizacion")
public class ControllerLocalizacion {


	@GetMapping
	public String verLocalizacion() {

		return "localizacion";

	}

}
