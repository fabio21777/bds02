package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.controllers.exception.ControllerNotFoundException;
import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;


@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	
	public EventDTO update(Long id, EventDTO updatedEvent) {
		try {
			Event event = eventRepository.getOne(id);
			ConvertEventDtoToEventEntity(event,updatedEvent);
			eventRepository.save(event);
			return new EventDTO(event);
		}	
		catch (EntityNotFoundException e) {
				throw new ControllerNotFoundException("ID invalid");
		}
		
	}
	
	public void ConvertEventDtoToEventEntity(Event event,EventDTO updatedEvent) {
		event.setName(updatedEvent.getName());
		event.setUrl(updatedEvent.getUrl());
		event.setDate(updatedEvent.getDate());
		event.setCity(cityRepository.getOne(updatedEvent.getCityId()));
	}
	
	
}
