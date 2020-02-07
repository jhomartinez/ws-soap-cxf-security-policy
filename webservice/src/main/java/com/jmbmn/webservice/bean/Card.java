package com.jmbmn.webservice.bean;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "card")
@Cacheable(true)
public class Card implements Serializable {

	private static final long serialVersionUID = 112316L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;
	
    
    @Column(nullable = false)
    private String alias;
    @Column(nullable = false)
    private String franchise;
    private boolean favorite;
    private boolean internationalCard;
    @Column(nullable = false)
    private String state;
	
	public Card() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public boolean isInternationalCard() {
		return internationalCard;
	}

	public void setInternationalCard(boolean internationalCard) {
		this.internationalCard = internationalCard;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
