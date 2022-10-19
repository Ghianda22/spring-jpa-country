package com.sts.country.jpa.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sts.country.jpa.app.model.Continent;
import com.sts.country.jpa.app.model.Region;
import com.sts.country.jpa.app.repository.ContinentRepository;
import com.sts.country.jpa.app.repository.RegionRepository;

@RestController
@RequestMapping("/regions")
public class RegionController {
    

    @Autowired
    private RegionRepository regionRepo;

    @GetMapping("/all")
    public List<Region> getAllContinents(){
        return (List<Region>) regionRepo.findAll();
    }
    
    @GetMapping("byid/{regionId}")
    public Region getRegionById(@PathVariable(value = "regionId") int regionId) {
		Optional<Region> region = regionRepo.findById(regionId);
		if (region.isPresent()) {
			return region.get();
		}
		else return new Region();
    }
	@GetMapping("bycontinentid/{continentId}")
    public List<Region> getRegionsByContinent(@PathVariable(value = "continentId") int continentId) {
//	    ContinentRepository continentRepo;
//	    Optional<Continent> continent = continentRepo.findById(continentId);
//	    if(continent.isPresent()) {	    	
//	    }
	    List<Region> regionsInContinent = regionRepo.findByContinentId(continentId);
	    return regionsInContinent;
    	
    }
}
