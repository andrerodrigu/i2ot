package project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Publications {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_publications;
	
	@Column(nullable=false)
	private Date timestamp;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User id_user;
	
	@OneToOne
	@JoinColumn(name="id_smartObject")
	private SmartObject id_smartObject;
	
	@OneToOne
	@JoinColumn(name="id_level_1")
	private Level_1 id_level_1;
	
	@OneToOne
	@JoinColumn(name="id_statusSensor")
	private StatusSensor id_statusSensor;
	
	@OneToOne
	@JoinColumn(name="id_privacyLevel")
	private PrivacyLevel id_privacyLevel;

	public Long getId_publications() {
		return id_publications;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public SmartObject getId_smartObject() {
		return id_smartObject;
	}

	public void setId_smartObject(SmartObject id_smartObject) {
		this.id_smartObject = id_smartObject;
	}

	public Level_1 getId_level_1() {
		return id_level_1;
	}

	public void setId_level_1(Level_1 id_level_1) {
		this.id_level_1 = id_level_1;
	}

	public StatusSensor getId_statusSensor() {
		return id_statusSensor;
	}

	public void setId_statusSensor(StatusSensor id_statusSensor) {
		this.id_statusSensor = id_statusSensor;
	}

	public PrivacyLevel getId_privacyLevel() {
		return id_privacyLevel;
	}

	public void setId_privacyLevel(PrivacyLevel id_privacyLevel) {
		this.id_privacyLevel = id_privacyLevel;
	}
	
}
