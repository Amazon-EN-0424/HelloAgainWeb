package com.ironhack.helloagainweb.repository;

import com.ironhack.helloagainweb.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    Optional<City> findByNameIgnoreCase(String name);
    List<City> findByCountryIgnoreCase(String country);
}
