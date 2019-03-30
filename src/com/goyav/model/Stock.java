package com.goyav.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

/*
 	Reference   string  `json:reference`
	Designation string  `json:designation`
	Famille     string  `json:famille`
	Gencod      string  `json:gencod`
	Quantite    float64 `json:quantite`
 * */
@XmlRootElement(name = "stock")
@XmlAccessorType (XmlAccessType.FIELD)
public class Stock {
	@SerializedName("reference")
	private String reference;
	@SerializedName("designation")
	private String designation;
	@SerializedName("famille")
	private String famille;
	@SerializedName("gencod")
	private String gencod;
	@SerializedName("quantite")
	private float quantite;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String reference, String designation, String famille, String gencod, float quantite) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.famille = famille;
		this.gencod = gencod;
		this.quantite = quantite;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public String getGencod() {
		return gencod;
	}

	public void setGencod(String gencod) {
		this.gencod = gencod;
	}

	public float getQuantite() {
		return quantite;
	}

	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	
}
