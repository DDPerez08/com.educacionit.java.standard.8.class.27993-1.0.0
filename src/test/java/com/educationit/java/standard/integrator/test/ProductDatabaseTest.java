
package com.educationit.java.standard.integrator.test;


import java.util.*;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.educationit.java.standard.integrator.model.Product;
import com.educationit.java.standard.integrator.service.IProduct;
import com.educationit.java.standard.integrator.service.impl.ProductJDBCSupport;


public class ProductDatabaseTest {


    public ProductDatabaseTest () {

        super ();
    }


    @Test
    @DisplayName ("Get Products of Day")
    public void testCreateOK () throws SQLException {

        IProduct<Product> dao = new ProductJDBCSupport ();

        List<Product> list = dao.findCreatedToday ();

        Assertions.assertFalse (list.isEmpty (), "There are products !!!");
    }
}