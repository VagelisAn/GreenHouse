package com.example.demo.controller;


import com.example.demo.model.Solid;
import com.example.demo.repository.SolidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/solid")
public class SolidController {

	@Autowired
	SolidRepository solidRepository;

	@GetMapping("/sensors")
	public ResponseEntity<List<Solid>> getAllTutorials() {
		try {
			List<Solid> solid = new ArrayList<Solid>();

				solidRepository.findAll().forEach(solid::add);

			if (solid.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(solid, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sensors/{id}")
	public ResponseEntity<Solid> getTutorialById(@PathVariable("id") long id) {
		Optional<Solid> tutorialData = solidRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/sensors")
	public ResponseEntity<Solid> createTutorial(@RequestBody Solid solid) {
		try {
			Solid _solid = solidRepository
					.save(solid);
			return new ResponseEntity<>(_solid, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/sensors/{id}")
	public ResponseEntity<Solid> updateTutorial(@PathVariable("id") long id, @RequestBody Solid solid) {
		Optional<Solid> tutorialData = solidRepository.findById(id);

		if (tutorialData.isPresent()) {
			Solid _sensor = tutorialData.get();
			_sensor.setModel(solid.getModel());
			_sensor.setName(solid.getName());
			_sensor.setTyoe(solid.getTyoe());
			return new ResponseEntity<>(solidRepository.save(_sensor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/sensors/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			solidRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/sensors")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			solidRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
