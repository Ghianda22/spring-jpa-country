package com.sts.country.jpa.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sts.country.jpa.app.model.Continent;

public interface ContinentRepository extends CrudRepository<Continent, Integer> {
}
