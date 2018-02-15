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
public class Rfid implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_rfid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String manufacturer;
	
	@Column(nullable=false, unique=true)
	private String model;
	
	@OneToOne
	@JoinColumn(name="id_level_1")
	private Level_1 id_level_1;

	public Long getId_rfid() {
		return id_rfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Level_1 getId_level_1() {
		return id_level_1;
	}

	public void setId_level_1(Level_1 id_level_1) {
		this.id_level_1 = id_level_1;
	}
	
}
