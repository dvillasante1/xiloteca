package com.xiloteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MUESTRAS")
public class Muestra {

	@Id
	private Integer id_muestra;
	private String cient_acept1;
	private String cient_acept2;
	private String cient_acept3;
	private String cient_acept4;
	private String familia;
	private String sinonimo;
	private String vulgar;
	private String muestra_jb;
	private String muestra_lab;
	private String muestra_mic;
	
	public Muestra() {
		super();
	}

	public Integer getId_muestra() {
		return id_muestra;
	}

	public String getCient_acept1() {
		return cient_acept1;
	}

	public String getCient_acept2() {
		return cient_acept2;
	}

	public String getCient_acept3() {
		return cient_acept3;
	}

	public String getCient_acept4() {
		return cient_acept4;
	}

	public String getFamilia() {
		return familia;
	}

	public String getSinonimo() {
		return sinonimo;
	}

	public String getVulgar() {
		return vulgar;
	}

	public String getMuestra_jb() {
		return muestra_jb;
	}

	public String getMuestra_lab() {
		return muestra_lab;
	}

	public String getMuestra_mic() {
		return muestra_mic;
	}

	@Override
	public String toString() {
		return "Muestra [id_muestra=" + id_muestra + ", cient_acept1=" + cient_acept1 + ", cient_acept2=" + cient_acept2
				+ ", cient_acept3=" + cient_acept3 + ", cient_acept4=" + cient_acept4 + ", familia=" + familia
				+ ", sinonimo=" + sinonimo + ", vulgar=" + vulgar + ", muestra_jb=" + muestra_jb + ", muestra_lab="
				+ muestra_lab + ", muestra_mic=" + muestra_mic + "]";
	}
	
	
}

