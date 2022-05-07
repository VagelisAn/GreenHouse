package com.example.demo.controller;


import com.example.demo.model.TemperatureHumidity;
import com.example.demo.repository.TempHumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/temp")
public class TempHumController {

	@Autowired
	TempHumRepository tempHumRepository;

	@GetMapping()
	public ResponseEntity<List<TemperatureHumidity>> getAllTutorials() {
		try {
			List<TemperatureHumidity> temperatureHumidities = new ArrayList<TemperatureHumidity>();

				tempHumRepository.findAll().forEach(temperatureHumidities::add);

			if (temperatureHumidities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(temperatureHumidities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TemperatureHumidity> getTutorialById(@PathVariable("id") long id) {
		Optional<TemperatureHumidity> tutorialData = tempHumRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping()
	public ResponseEntity<TemperatureHumidity> createTutorial(@RequestBody TemperatureHumidity temperatureHumidity) {
		System.out.println(temperatureHumidity.toString());
		try {
			TemperatureHumidity _temperatureHumidity = tempHumRepository
					.save(temperatureHumidity);
			return new ResponseEntity<>(_temperatureHumidity, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<TemperatureHumidity> updateTutorial(@PathVariable("id") long id, @RequestBody TemperatureHumidity temperatureHumidity) {
		Optional<TemperatureHumidity> tutorialData = tempHumRepository.findById(id);

		if (tutorialData.isPresent()) {
			TemperatureHumidity _sensor = tutorialData.get();
			_sensor.setModel(temperatureHumidity.getModel());
			_sensor.setName(temperatureHumidity.getName());
			_sensor.setTyoe(temperatureHumidity.getTyoe());
			return new ResponseEntity<>(tempHumRepository.save(_sensor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tempHumRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping()
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tempHumRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}



}
