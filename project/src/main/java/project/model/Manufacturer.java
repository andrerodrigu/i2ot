package project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Manufacturer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_manufacturer;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String CNPJ;
	
	@Column(nullable=false)
	private int newField;
	
	@Column(nullable=false)
	private String publicPlace;
	
	@Column(nullable=false, unique=true)
	private int number;
	
	@Column(nullable=false)
	private String neighborhood;
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private String state;
	
	@Column(nullable=false)
	private String postalCode;
	
	@OneToOne
	@JoinColumn(name="id_phone")
	private Phone id_phone;

	public Long getId_manufacturer() {
		return id_manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public int getNewField() {
		return newField;
	}

	public void setNewField(int newField) {
		this.newField = newField;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Phone getId_phone() {
		return id_phone;
	}

	public void setId_phone(Phone id_phone) {
		this.id_phone = id_phone;
	}
	
}
