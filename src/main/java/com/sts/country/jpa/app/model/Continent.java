package com.sts.country.jpa.app.model;

import javax.persistence.*;

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int continentId) {
        this.id = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

