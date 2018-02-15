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
public class InfraredSensor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id_infraredSensor;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private int distance;
	
	@Column(nullable=false)
	private int reactionTime;
	
	@Column(nullable=false)
	private int readingTime;
	
	@OneToOne
	@JoinColumn(name="id_level_1")
	private Level_1 id_level_1;

	public Long getId_infraredSensor() {
		return id_infraredSensor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getReactionTime() {
		return reactionTime;
	}

	public void setReactionTime(int reactionTime) {
		this.reactionTime = reactionTime;
	}

	public int getReadingTime() {
		return readingTime;
	}

	public void setReadingTime(int readingTime) {
		this.readingTime = readingTime;
	}

	public Level_1 getId_level_1() {
		return id_level_1;
	}

	public void setId_level_1(Level_1 id_level_1) {
		this.id_level_1 = id_level_1;
	}
	
}
