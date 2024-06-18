package com.ironhack.helloagainweb.service;

import com.ironhack.helloagainweb.model.City;
import com.ironhack.helloagainweb.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {

    private final CityRepository cityRepository;


    public List<City> findAll() {
        log.info("Request to find all cities");
        return cityRepository.findAll();
    }

    public Optional<City> findByName(String name) {
        log.info("Request to find city by name: {}", name);
        return cityRepository.findByNameIgnoreCase(name);
    }

    public List<City> findByCountry(String country) {
        log.info("Request to find cities by country: {}", country);
        return cityRepository.findByCountryIgnoreCase(country);
    }

    @Transactional // not needed but good practice, google it
    public City create(City city) {
        log.info("Request to create city: {}", city);
        return cityRepository.save(city);
    }

    @Transactional
    public City updateCity(UUID id, City city) {
        var cityToUpdate = cityRepository.findById(id).orElseThrow();
        cityToUpdate.setName(city.getName());
        cityToUpdate.setCountry(city.getCountry());
        return cityRepository.save(cityToUpdate);
    }

    @Transactional
    public City updateCityName(UUID id, String name) {
        var cityToUpdate = cityRepository.findById(id).orElseThrow();
        cityToUpdate.setName(name);
        return cityRepository.save(cityToUpdate);
    }

    @Transactional
    public void deleteCity(UUID id) {
        log.info("Request to delete city with id: {}", id);
        cityRepository.deleteById(id);
    }



}
