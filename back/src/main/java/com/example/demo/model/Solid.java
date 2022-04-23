package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "solid")
public class Solid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String tyoe;

	@Column(name = "model")
	private String model;

	@Column(name = "solid")
	private float solid;

	@Column(name = "green_house")
	private String greenHouse;

	public Solid() {

	}

	public Solid(String name, String tyoe, String model, float solid, String greenHouse) {
		this.name = name;
		this.tyoe = tyoe;
		this.model = model;
		this.solid = solid;
		this.greenHouse = greenHouse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTyoe() {
		return tyoe;
	}

	public void setTyoe(String tyoe) {
		this.tyoe = tyoe;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getSolid() {
		return solid;
	}

	public void setSolid(float solid) {
		this.solid = solid;
	}

	public String getGreenHouse() {
		return greenHouse;
	}

	public void setGreenHouse(String greenHouse) {
		this.greenHouse = greenHouse;
	}
}
