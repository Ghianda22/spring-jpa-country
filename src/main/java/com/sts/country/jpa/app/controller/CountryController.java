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
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "countryId") int countryId) {
        Optional<Country> country = countryRepo.findById(countryId);
        if (country.isPresent())
//            return country.get();
            return new ResponseEntity<Country>(country.get(), HttpStatus.OK);
        else
//            return new Country();
            return new ResponseEntity<Country>((Country) null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return new ResponseEntity<Country>(
                countryRepo.save(country), HttpStatus.CREATED
        );

    }

    @PutMapping("/update/byid/{countryId}")
    public ResponseEntity<Country> updateCountry(
            @PathVariable(value = "countryId") int countryId,
            @RequestBody Country countryWithUpdates){
        Optional<Country> countryToBeUpdated = countryRepo.findById(countryId);
        if(countryToBeUpdated.isPresent()){
            Country country = countryToBeUpdated.get();
            country.setName(countryWithUpdates.getName());
            country.setArea(countryWithUpdates.getArea());
            country.setCountryCode2(countryWithUpdates.getCountryCode2());
            country.setCountryCode3(countryWithUpdates.getCountryCode3());
            country.setRegion(countryWithUpdates.getRegion());
            return new ResponseEntity<Country>(countryRepo.save(country), HttpStatus.OK);
        }else return new ResponseEntity<Country>((Country) null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/byid/{countryId}")
    public void deleteCountryById(@PathVariable(value = "countryId") int countryId){
        countryRepo.deleteById(countryId);
    }

}
