package com.ironhack.helloagainweb.service;

import com.ironhack.helloagainweb.model.City;
import com.ironhack.helloagainweb.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



}
