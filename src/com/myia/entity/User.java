package com.myia.entity;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.sun.istack.NotNull;



// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@XmlRootElement
 public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7883100828526539985L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	/** The password. */
	@XmlTransient
	@Column
	private String password;

	/** The mail. */
	@Column(unique = true)
	@NotNull
	private String username;
	
	/** The lastlogin. */
	@Column
	private Date lastlogin=null;

	/** The status. */
	@Column
	private boolean isLoggedIn=false;
	
	/** The status. */
	@Column
	private boolean isEnabled=false;
	
	/** The archived. */
	@Column
	private boolean isdeleted=false;
	
		
	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the lastlogin
	 */
	public Date getLastlogin() {
		return this.lastlogin;
	}


	/**
	 * @param lastlogin the lastlogin to set
	 */
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}


	/**
	 * @return the isLoggedIn
	 */
	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}


	/**
	 * @param isLoggedIn the isLoggedIn to set
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return this.isEnabled;
	}


	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	/**
	 * @return the isdeleted
	 */
	public boolean isIsdeleted() {
		return this.isdeleted;
	}


	/**
	 * @param isdeleted the isdeleted to set
	 */
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	public User(Long id,  String username,String password, Date lastlogin, boolean isLoggedIn, boolean isEnabled, boolean isdeleted) {
		this.id         = id;
		this.password   = password;
		this.username   = username;
		this.lastlogin  = lastlogin;
		this.isLoggedIn = isLoggedIn;
		this.isEnabled  = isEnabled;
		this.isdeleted  = isdeleted;
	}


	
	public User(Long id, String username, String password) {
		this.id         = id;
		this.password   = password;
		this.username   = username;
	}

	
	public User(  ) {
		 }


	public User(String username, String password) {
		this.password   = password;
		this.username   = username;
	}

	
}
