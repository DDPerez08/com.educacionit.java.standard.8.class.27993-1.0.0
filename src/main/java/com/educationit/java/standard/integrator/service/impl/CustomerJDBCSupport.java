
package com.educationit.java.standard.integrator.service.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.educationit.java.standard.integrator.model.Customer;
import com.educationit.java.standard.integrator.model.Product;
import com.educationit.java.standard.integrator.service.Database;
import com.educationit.java.standard.integrator.service.ICustomer;


public class CustomerJDBCSupport implements ICustomer<String, Customer> {


    private Database dataBase;


    public CustomerJDBCSupport () throws SQLException {

        super ();

        this.dataBase = new Database ();
    }

    @Override
    public void create (Customer entity) throws SQLException {

        String query = "insert into customer values (?, ?, ?)";

        PreparedStatement pst = this.dataBase.getConexion().prepareStatement (query);

        pst.setString (1, entity.getFullName ());
        pst.setString (2, entity.getEmail ());
        pst.setString (3, entity.getPassword ());

        pst.execute ();
    }

    @Override
    public void delete (String key) throws SQLException {

        String query = "delete from customer where email = ?";

        PreparedStatement pst = this.dataBase.getConexion().prepareStatement (query);

        pst.setString (1, key);

        pst.execute ();
    }
}