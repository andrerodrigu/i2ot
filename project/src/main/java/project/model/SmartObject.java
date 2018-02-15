package project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name = "SmartObject.findAll", query = "SELECT u FROM SmartObject u"),
	@NamedQuery(name = "SmartObject.findByItem", query = "SELECT u FROM SmartObject u WHERE u.item = :item")
})
@Entity
public class SmartObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String findAll = "SmartObject.findAll";
	public static final String findByItem = "SmartObject.findByItem";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_smartObject;
	
	@Column
	private String item;
	
	@Column
	private String description;
	
	@Column
	private String category;
	
	@Column(name="conditionXXX")
	private String condition;
	
	@Column
	private Date purchaseDate;
	
	@Column
	private int purchasePrice;
	
	@Column
	private int currentValue;
	
	@Column
	private String manufacturer; 
	
	@Column
	private String model;
	
	private String smartObjectSearchType;

	@OneToOne
	@JoinColumn(name="id_consignor")
	private Consignor id_consignor;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User id_user;
	
	@OneToOne
	@JoinColumn(name="id_level_1")
	private Level_1 id_level_1;
	
	public Long getId_smartObject() {
		return id_smartObject;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Consignor getId_consignor() {
		return id_consignor;
	}

	public void setId_consignor(Consignor id_consignor) {
		this.id_consignor = id_consignor;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public Level_1 getId_level_1() {
		return id_level_1;
	}

	public void setId_level_1(Level_1 id_level_1) {
		this.id_level_1 = id_level_1;
	}

	public String getSmartObjectSearchType() {
		return smartObjectSearchType;
	}

	public void setSmartObjectSearchType(String smartObjectSearchType) {
		this.smartObjectSearchType = smartObjectSearchType;
	}
	
}
