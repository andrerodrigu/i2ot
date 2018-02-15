package project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StatusSensor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_statusSensor;
	
	@OneToOne
	@JoinColumn(name="id_infraredSensor")
	private InfraredSensor id_infraredSensor;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date timestamp;
	
	@Column(nullable=false)
	private String result;

	public Long getId_statusSensor() {
		return id_statusSensor;
	}
	
	public InfraredSensor getId_infraredSensor() {
		return id_infraredSensor;
	}

	public void setId_sensor(InfraredSensor id_infraredSensor) {
		this.id_infraredSensor = id_infraredSensor;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
