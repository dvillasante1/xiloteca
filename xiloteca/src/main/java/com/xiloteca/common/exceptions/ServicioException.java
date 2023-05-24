package com.xiloteca.common.exceptions;

@SuppressWarnings("serial")
public class ServicioException extends Exception {

	private final String codigo;
	
	public ServicioException(String codigo, Exception e) {
		super(e.getMessage());
		this.codigo=codigo;
	}

	public ServicioException(String codigo) {
		this.codigo=codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
