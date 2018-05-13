
package com.educationit.java.standard.integrator.model;


import java.time.LocalDate;


public class Product {


    private int id;

    private String name;

    private String description;

    private LocalDate createdAt;


    public Product () {

        super ();
    }

    public Product (int id, String name, String description) {

        super ();

        this.id   = id;
        this.name = name;
        this.description = description;
    }

    public Product (int id, String name, String description,
                    LocalDate createdAt) {

        super ();

        this.id   = id;
        this.name = name;
        this.description = description;
        this.createdAt   = createdAt;
    }


    public int getId () {

        return this.id;
    }

    public void setId (int id) {

        this.id = id;
    }

    public String getName () {

        return this.name;
    }

    public void setName (String name) {

        this.name = name;
    }

    public String getDescription () {

        return this.description;
    }

    public void setDescription (String description) {

        this.description = description;
    }

    public LocalDate getCreatedAt () {

        return this.createdAt;
    }

    public void setCreatedAt (LocalDate createdAt) {

        this.createdAt = createdAt;
    }
}
