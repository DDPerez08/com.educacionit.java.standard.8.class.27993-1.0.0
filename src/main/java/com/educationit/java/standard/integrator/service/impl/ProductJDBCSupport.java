
package com.educationit.java.standard.integrator.service.impl;


import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.educationit.java.standard.integrator.model.Product;
import com.educationit.java.standard.integrator.service.Database;
import com.educationit.java.standard.integrator.service.IProduct;


public class ProductJDBCSupport implements IProduct<Product> {


    private Database dataBase;


    public ProductJDBCSupport () throws SQLException {

        super ();

        this.dataBase = new Database ();
    }


    @Override
    public List<Product> findCreatedToday () throws SQLException {


        String query = String.format ("select * from product where day (createdAt) = %d and month (createdAt) = %d",
                LocalDate.now().getDayOfMonth (), LocalDate.now ().getMonthValue ());

        Statement st = this.dataBase.getConexion().createStatement ();

        ResultSet rs = st.executeQuery (query);

        List<Product> list = new ArrayList<> ();
        while (rs.next ()) {

            list.add (new Product (rs.getInt ("id"),
                                   rs.getString ("name"),
                                   rs.getString ("description")));

        }

        return list;
    }
}
