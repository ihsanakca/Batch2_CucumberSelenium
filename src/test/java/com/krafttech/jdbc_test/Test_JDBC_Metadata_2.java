package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Metadata_2 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query="select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        try (Connection connection= DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet  resultSet = statement.executeQuery(query);
        )
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());

//            for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                System.out.println("1.row "+i+"'nci columndaki değer--A>" + resultSet.getString(i));
//            }

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(metaData.getColumnName(i)+"\t");
            }
            System.out.println();
            while(resultSet.next()){
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i)+"\t");
                }
                System.out.println();
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
