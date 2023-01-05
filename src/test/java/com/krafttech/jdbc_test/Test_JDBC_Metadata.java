package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Metadata {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.150.3:1433;" +
                "DatabaseName=u0583688_vlk;encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password = "VolkanAntalya159*";
        String query = "select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2 = "select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount = " + columnCount);
            String columnName9 = metaData.getColumnName(9);
            System.out.println("columnName9 = " + columnName9);

            for (int i = 1; i <=columnCount ; i++) {
                System.out.println( "kolon "+i+" ->"+metaData.getColumnName(i));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
