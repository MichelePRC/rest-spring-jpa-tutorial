package org.slevin.common;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long uid;
	
	
	@XmlElement
    @Column(unique = true)
	private String email;
	
	@XmlElement
	private String modulus;
	
	@XmlElement
	private String exponent;
	
	/* campo gestito da AS-Server (ex-RMS)
	 * serve per memorizzare la chiave segreta UNIVOCA per utente
	 * da generare pseudorandom alla creazione
	 */
	@XmlElement
    @Column(unique = true)
	private String secret;
	
	
	
	

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModulus() {
		return modulus;
	}

	public void setModulus(String modulus) {
		this.modulus = modulus;
	}

	public String getExponent() {
		return exponent;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	
	
	

}
