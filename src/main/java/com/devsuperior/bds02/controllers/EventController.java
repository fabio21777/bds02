package com.devsuperior.bds02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;


@ControllerAdvice
@RequestMapping(value = "/events")
public class EventController {
	@Autowired
	EventService eventService;
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO updatedEvent){
		EventDTO event = eventService.update(id, updatedEvent); 
		return ResponseEntity.ok(event);
	}
}