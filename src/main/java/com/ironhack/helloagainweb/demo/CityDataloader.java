package com.ironhack.helloagainweb.demo;



import com.ironhack.helloagainweb.model.City;
import com.ironhack.helloagainweb.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@Profile("load_demo_data")
public class CityDataloader implements CommandLineRunner {

    private final CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");

        cityRepository.save(new City("Madrid", "Spain"));
        cityRepository.save(new City("Barcelona", "Spain"));
        cityRepository.save(new City("Paris", "France"));
        cityRepository.save(new City("Berlin", "Germany"));
        cityRepository.save(new City("London", "United Kingdom"));
        cityRepository.save(new City("Catania", "Italy"));

    }
}
