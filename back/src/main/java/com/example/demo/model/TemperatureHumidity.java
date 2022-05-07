package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "temperature_humidity")
public class TemperatureHumidity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String typeSensor;

	@Column(name = "model")
	private String model;

	@Column(name = "temperature")
	private float temperature;

	@Column(name = "humidity")
	private float humidity;

	@Column(name = "green_house")
	private String greenHouse;

	public TemperatureHumidity() {

	}

	public TemperatureHumidity(String name, String typeSensor, String model, float temperature, float humidity, String greenHouse) {
		this.name = name;
		this.typeSensor = typeSensor;
		this.model = model;
		this.temperature = temperature;
		this.humidity = humidity;
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
		return typeSensor;
	}

	public void setTyoe(String typeSensor) {
		this.typeSensor = typeSensor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public String getGreenHouse() {
		return greenHouse;
	}

	public void setGreenHouse(String greenHouse) {
		this.greenHouse = greenHouse;
	}

	@Override
	public String toString() {
		return "TemperatureHumidity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", tyoe='" + typeSensor + '\'' +
				", model='" + model + '\'' +
				", temperature=" + temperature +
				", humidity=" + humidity +
				", greenHouse='" + greenHouse + '\'' +
				'}';
	}
}
