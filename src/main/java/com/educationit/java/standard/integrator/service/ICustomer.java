
package com.educationit.java.standard.integrator.service;


import java.sql.SQLException;


public interface ICustomer<P, T> {


    void create (T entity) throws SQLException;

    void delete (P key) throws SQLException;
}