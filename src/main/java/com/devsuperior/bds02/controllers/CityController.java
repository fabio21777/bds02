package com.devsuperior.bds02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;

@ControllerAdvice
@RequestMapping(value = "/cities")
public class CityController {
	@Autowired
	CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>>findAll(){
		List<CityDTO> cities = cityService.findall();
		return ResponseEntity.ok(cities);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		cityService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
