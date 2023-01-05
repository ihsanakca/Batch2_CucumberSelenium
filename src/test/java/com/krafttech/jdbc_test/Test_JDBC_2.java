package com.krafttech.jdbc_test;

import java.sql.*;
import java.util.Arrays;

public class Test_JDBC_2 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query="select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";


        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();

            System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            System.out.println(resultSet.getRow()+" | "+resultSet.getString(1));
            System.out.println("resultSet.getString(marka) = " + resultSet.getString("marka"));
            resultSet.next();
            System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            System.out.println(resultSet.getRow()+" | "+resultSet.getString(1));
            System.out.println("resultSet.getString(marka) = " + resultSet.getString("marka"));
            int motorHacmi = resultSet.getInt("motor");
            System.out.println("motorHacmi = " + motorHacmi);
            resultSet.next();
            System.out.println("resultSet.getString(model) = " + resultSet.getString("model"));


        } catch (SQLException e) {
            System.out.println("CONNECTION ERROR"+e.getMessage());
        }
    }
}
