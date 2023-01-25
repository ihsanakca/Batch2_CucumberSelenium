package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Day2 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query="select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
        String query2="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        Connection connection= null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet=statement.executeQuery(query);
            System.out.println("Connection is on");

            resultSet.close();
            statement.close();
            connection.close();

//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.next();
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.previous();
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.last();
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.first();
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.absolute(10);
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//            resultSet.beforeFirst();
//            resultSet.next();
//            resultSet.afterLast();
//            resultSet.previous();
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));
//
//            System.out.println("resultSet.getString(8) = " + resultSet.getString(8));

        //    resultSet.beforeFirst();

//            for (int i = 1; i <=10 ; i++) {
//                resultSet.absolute(i);
//                System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
//                System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
//            }

//            while  (resultSet.next()){
//                System.out.println(resultSet.getString(1)+"-->"+resultSet.getString(3));
//            }

//            resultSet.next();
//            System.out.println("row sıra numarası = " + resultSet.getRow());

//            resultSet.last();
//            System.out.println("row sıra numarası = " + resultSet.getRow());

            int toplamRow=0;
            while(resultSet.next()){
                System.out.println("row sıra numarası = " + resultSet.getRow());
                toplamRow++;
            }
            System.out.println("toplam Row sayısı = " + toplamRow);





        } catch (SQLException e) {
            System.out.println("Connection problem"+e.getMessage());
        }

    }
}
