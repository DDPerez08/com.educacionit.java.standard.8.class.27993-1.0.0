
package com.educationit.java.standard.integrator.service;


import java.util.List;
import java.sql.SQLException;


public interface IProduct<T> {


    List<T> findCreatedToday () throws SQLException;
}