package com.ironhack.helloagainweb.controller;

import com.ironhack.helloagainweb.model.City;
import com.ironhack.helloagainweb.service.CityService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

//    CRUD operations:  x Create(POST),  x Read(GET), x Update(PUT, PATCH), x Delete(DELETE)
//    DTO: Data Transfer Object

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
    public City create(@RequestBody @Valid City city) {
        return cityService.create(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") UUID id, @RequestBody @Valid City city) {
        return cityService.updateCity(id, city);
    }


    @PatchMapping("/{id}")
    public City updateCityName(@PathVariable("id") UUID id, @RequestBody @Valid @Size(min = 2, max = 10) String name) {
        return cityService.updateCityName(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable("id") UUID id) {
        cityService.deleteCity(id);
    }

}
