package com.ironhack.helloagainweb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, name = "city_name")
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Z]{2}$", message = "Country code must be two uppercase letters")
    private String country;

    @JsonInclude(Include.NON_NULL) // this hide the field if it is null
    private WeatherForecast currentWeather;
    // Should we save the current weather in the database?

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
