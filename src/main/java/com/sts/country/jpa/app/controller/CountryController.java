package com.sts.country.jpa.app.controller;

import com.sts.country.jpa.app.model.Country;
import com.sts.country.jpa.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @GetMapping("/all")
    public List<Country> getAllCountries(){
        return (List<Country>) countryRepo.findAll();
    }

    @GetMapping("byid/{countryId}")
    public Country getCountryById(@PathVariable(value = "countryId") int countryId) {
        Optional<Country> country = countryRepo.findById(countryId);
        if (country.isPresent()) return country.get();
        else return new Country();
    }

    @PostMapping("/create")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return new ResponseEntity<Country>(
                countryRepo.save(country), HttpStatus.CREATED
        );

    }

}
