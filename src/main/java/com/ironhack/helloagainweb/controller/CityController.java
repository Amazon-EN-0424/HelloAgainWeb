package com.ironhack.helloagainweb.controller;

import com.ironhack.helloagainweb.model.City;
import com.ironhack.helloagainweb.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/name/{name}")
    public Optional<City> findByName(@PathVariable("name") String name) {
        return cityService.findByName(name);
    }

    @GetMapping("/country/{country}")
    public List<City> findByCountry(@PathVariable("country") String country) {
        return cityService.findByCountry(country);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }


}
