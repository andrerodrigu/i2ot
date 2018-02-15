package project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(name = "Antennas.findByNumber", query = "SELECT u FROM Antennas u WHERE u.number = :number"),
    @NamedQuery(name = "Antennas.findAll", query = "select u from Antennas u")
})
@Entity
public class Antennas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String findByNumber = "Antennas.findByNumber";
	public static final String findAll = "Antennas.findAll";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_antennas;
	
	@Column(nullable=false, unique=true)
	private int number;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne
	@JoinColumn(name="id_rfid")
	private Rfid id_rfid;
	
	@OneToOne
	@JoinColumn(name="id_level_1")
	private Level_1 id_level_1;

	public Long getId_antennas() {
		return id_antennas;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rfid getId_rfid() {
		return id_rfid;
	}

	public void setId_rfid(Rfid id_rfid) {
		this.id_rfid = id_rfid;
	}

	public Level_1 getId_level_1() {
		return id_level_1;
	}

	public void setId_level_1(Level_1 id_level_1) {
		this.id_level_1 = id_level_1;
	}

}
