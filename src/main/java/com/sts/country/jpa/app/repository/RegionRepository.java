package com.sts.country.jpa.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sts.country.jpa.app.model.Continent;
import com.sts.country.jpa.app.model.Region;

public interface RegionRepository extends CrudRepository<Region, Integer> {
	public List<Region> findByContinentId(int continentId);
}
