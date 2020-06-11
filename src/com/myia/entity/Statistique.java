package com.myia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Statistique implements Serializable {

	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** The poids. */
	@Column(name = "poids")
	private String poids;
	
	/** The temperature. */
	@Column(name = "temperature")
	private String temperature;
	
	/** The vaccin. */
	@Column(name = "vaccin")
	private String vaccin;
	
	/** The repas. */
	@Column(name = "repas")
	private String repas;
	
	/** The date. */
	@Column(name = "datemodified")
	private Date datemodified;
	
	
	/** The date. */
	@Column(name = "datecreated")
	private Date datecreated;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPoids() {
		return poids;
	}


	public void setPoids(String poids) {
		this.poids = poids;
	}


	public String getTemperature() {
		return temperature;
	}


	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getVaccin() {
		return vaccin;
	}


	public void setVaccin(String vaccin) {
		this.vaccin = vaccin;
	}


	public String getRepas() {
		return repas;
	}


	public void setRepas(String repas) {
		this.repas = repas;
	}


	public Date getDatemodified() {
		return datemodified;
	}


	public void setDatemodified(Date datemodified) {
		this.datemodified = datemodified;
	}


	public Date getDatecreated() {
		return datecreated;
	}


	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}


	public Statistique(String poids, String temperature, String vaccin, String repas, Date datemodified,
			Date datecreated) {
		super();
		this.poids = poids;
		this.temperature = temperature;
		this.vaccin = vaccin;
		this.repas = repas;
		this.datemodified = datemodified;
		this.datecreated = datecreated;
	}


	public Statistique() {
		
	}
	
	
	
}
