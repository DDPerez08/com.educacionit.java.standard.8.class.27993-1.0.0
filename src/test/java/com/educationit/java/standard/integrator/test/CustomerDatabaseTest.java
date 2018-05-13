
package com.educationit.java.standard.integrator.test;


import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.educationit.java.standard.integrator.model.Customer;
import com.educationit.java.standard.integrator.service.ICustomer;
import com.educationit.java.standard.integrator.service.impl.CustomerJDBCSupport;


public class CustomerDatabaseTest {


    public CustomerDatabaseTest () {

        super ();
    }


    @Test
    @DisplayName ("Create new Customer [OK]")
    public void testCreateOK () throws SQLException {

        ICustomer<String, Customer> dao = new CustomerJDBCSupport ();

        dao.create (new Customer ("Homer Simpson",
                                  "hsimpson@hotmail.com",
                                        "qwerty"));

        Assertions.assertTrue (Boolean.TRUE);
    }

    @Test
    @DisplayName ("Create new Customer [KO]")
    public void testCreateKO () {

        Assertions.assertThrows (SQLException.class, () -> {

            ICustomer<String, Customer> dao = new CustomerJDBCSupport ();

            dao.create (new Customer ("Homer Simpson",
                    "hsimpson@hotmail.com",
                    "qwerty"));
        });
    }

    @Test
    @DisplayName ("Delete a Customer")
    public void testDelete () throws SQLException {

        ICustomer<String, Customer> dao = new CustomerJDBCSupport ();

        dao.delete ("hsimpson@hotmail.com");

        Assertions.assertTrue (Boolean.TRUE);
    }
}