package com.devsuperior.bds02.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.controllers.exception.ControllerNotFoundException;
import com.devsuperior.bds02.controllers.exception.DataBaseException;
import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	
	public List<CityDTO>findall(){
		List<City> citiesEntities = cityRepository.findAll(Sort.by("name"));
		List<CityDTO> citiesDto =  new ArrayList<>();
		citiesEntities.forEach(city -> citiesDto.add(new CityDTO(city)));
		return citiesDto;
	}

	public void delete(Long id) {
		try {
			cityRepository.deleteById(id);
		}
		
		catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException("ID NOT FOUND" + id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Data Integrity Violation");
		}
	} 
}
