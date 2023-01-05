package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Closing {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query="select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        try (Connection connection= DriverManager.getConnection(url,userName,password);
             Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet  resultSet = statement.executeQuery(query);
        )
        {
            resultSet.next();
            System.out.println(resultSet.getString(2));

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("connection kapandı");


//        Connection connection=null;
//        Statement statement=null;
//        ResultSet resultSet=null;
//
//        try {
//            connection= DriverManager.getConnection(url,userName,password);
//            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            resultSet = statement.executeQuery(query);
//            resultSet.next();
//            System.out.println(resultSet.getString(2));
//        }
//        catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
    }
}
