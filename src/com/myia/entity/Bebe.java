package com.myia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Bebe implements Serializable {

	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** The nom. */
	@Column(name = "name")
	private String name;
	
	/** The prenom. */
	@Column(name = "forName")
	private String forName;
	
	/** The sex. */
	@Column(name = "sex")
	private String sex;
	
	/** The date naissance. */
	@Column(name = "dateBirth")
	private Date dateBirth;
	
	/** The user. */
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user",nullable = false,insertable = true,updatable = true)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForName() {
		return forName;
	}

	public void setForName(String forName) {
		this.forName = forName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bebe(String name, String forName, String sex, Date dateBirth, User user) {
		super();
		this.name = name;
		this.forName = forName;
		this.sex = sex;
		this.dateBirth = dateBirth;
		this.user = user;
	}

	public Bebe() {
		
	}
	
	
	
	
	
	
}
