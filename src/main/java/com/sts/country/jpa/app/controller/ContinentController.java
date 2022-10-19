package com.sts.country.jpa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sts.country.jpa.app.model.Continent;
import com.sts.country.jpa.app.repository.ContinentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/continents")
public class ContinentController {

    @Autowired
    private ContinentRepository continentRepo;

    @GetMapping("/all")
    public List<Continent> getAllContinents(){
        return (List<Continent>) continentRepo.findAll();
    }
    
    @GetMapping("byid/{continentId}")
    public Continent getContinentById(@PathVariable(value = "continentId") int continentId) {
		Optional<Continent> continent = continentRepo.findById(continentId);
		if (continent.isPresent()) return continent.get();
		else return new Continent();
    }
//	@GetMapping("")
//	public Continent index() {
//		return new Continent();
//	}

}
