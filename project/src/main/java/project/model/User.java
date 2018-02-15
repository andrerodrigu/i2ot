package project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
	@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
	@NamedQuery(name = "User.findByDepartment", query = "SELECT u FROM User u WHERE u.department = :department"),
	@NamedQuery(name = "User.findByFunctionalEnrollment", query = "SELECT u FROM User u WHERE u.functionalEnrollment = :functionalEnrollment"),
	@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
})
@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String findAll = "User.findAll";
	public static final String findByUserName = "User.findByUserName";
	public static final String findByPassword = "User.findByPassword";
	public static final String findByName = "User.findByName";
	public static final String findByDepartment = "User.findByDepartment";
	public static final String findByFunctionalEnrollment = "User.findByFunctionalEnrollment";
	public static final String findByLogin = "User.findByLogin";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_user;
	
	@Column(nullable=false, unique=true)
	private String userName;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(nullable=false, unique=true)
	private Long functionalEnrollment;
	
	@Column(nullable=false)
	private String department;
	
	@OneToOne
	@JoinColumn(name="id_level_2")
	private Level_2 id_level_2;
	
	@OneToOne
	@JoinColumn(name="id_phone")
	private Phone id_phone;
	
	@Column(nullable=false, unique=true)
	private int RG;
	
	@Column(unique=true)
	private int CPF;
	
	@Column
	private String state;
	
	@Column
	private String postalCode;
	
	@Column(nullable=false)
	private String city;
	
	@Column
	private String neighborhood;
	
	@Column
	private int number;
	
	@Column
	private boolean active;

	public Long getId_user() {
		return id_user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getFunctionalEnrollment() {
		return functionalEnrollment;
	}

	public void setFunctionalEnrollment(Long functionalEnrollment) {
		this.functionalEnrollment = functionalEnrollment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Level_2 getId_level_2() {
		return id_level_2;
	}

	public void setId_level_2(Level_2 id_level_2) {
		this.id_level_2 = id_level_2;
	}

	public Phone getId_phone() {
		return id_phone;
	}

	public void setId_phone(Phone id_phone) {
		this.id_phone = id_phone;
	}

	public int getRG() {
		return RG;
	}

	public void setRG(int rG) {
		RG = rG;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}


