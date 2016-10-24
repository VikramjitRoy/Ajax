package com.mindtree.tables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class FetchData {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = FetchData.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
 /*
  * create table Customer (CustomerName varchar(255), ContactName varchar(255), Address varchar(255), City varchar(255), PostalCode varchar(255), Country varchar(255));   
  */
    public static ArrayList<Employee> getAllCountries() {
    	connection = FetchData.getConnection();
        ArrayList<Employee> customerList = new ArrayList<Employee>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer");
        
            while(rs.next()) {	
            	Employee customer=new Employee();
            	customer.setAddress(rs.getString(1));
            	customer.setCity(rs.getString(2));
            	customer.setContactName(rs.getString(3));
            	customer.setCountry(rs.getString(4));
            	customer.setCustomerName(rs.getString(5));
            	customer.setPostalCode(rs.getString(6));
            	customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}