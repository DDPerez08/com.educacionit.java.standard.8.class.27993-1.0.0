
package com.educationit.java.standard.integrator.model;


public class Customer {


    private String fullName;

    private String email;

    private String password;


    public Customer () {

        super ();
    }

    public Customer (String fullName, String email, String password) {

        super ();

        this.fullName = fullName;
        this.email    = email;
        this.password = password;
    }


    public String getFullName () {

        return this.fullName;
    }

    public void setFullName (String fullName) {

        this.fullName = fullName;
    }

    public String getEmail () {

        return this.email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getPassword () {

        return this.password;
    }

    public void setPassword (String password) {

        this.password = password;
    }
}
