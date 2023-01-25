package com.krafttech.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Utilities {

    static String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
    static String userName = "u0583688_vlk";
    static String password = "VolkanAntalya159*";
    static String query = "select * from [dbo].[regions]";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;

    public static void main(String[] args) throws SQLException {
        connectionJDBC();
        runQuery();
        getRowCount();
        getResultSetMetadata();
        getColumnCount();

        for (String str : getRowDataAsList(2)) {
            System.out.print(str + "\t");
        }


        closeJDBC();

    }

    static void connectionJDBC() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection OK!!");
        } catch (SQLException e) {
            System.out.println("Connection Failed!!");
            e.getMessage();
        }
    }

    static ResultSet runQuery() {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
            System.out.println("resultSet get DB");
        } catch (SQLException e) {
            System.out.println("resultSET failed");
            e.getMessage();
        }
        return resultSet;
    }

    static void closeJDBC() {
        try {
            if (resultSet != null) {
                resultSet.close();
                System.out.println("resultSet closed!!");
            }
            if (resultSet != null) {
                statement.close();
                System.out.println("statement closed!!");
            }
            if (resultSet != null) {
                connection.close();
                System.out.println("connection closed!!");
            }

        } catch (SQLException e) {
            System.out.println("close JDBC failed");
            e.getMessage();
        }
    }

    /**
     * tablonun satır sayısını elde etme metodu
     */
    static int getRowCount() {
        int row = 0;
        try {
            resultSet.last();
            row = resultSet.getRow();
            System.out.println("satir sayisi= " + row);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("row count can not get");
            e.getMessage();
        }
        return row;
    }

    /**
     * kolon sayısının elde edilmesi
     */
    static int getColumnCount() {
        int columnCount = 0;
        try {
            columnCount = resultSetMetaData.getColumnCount();
            //System.out.println("column sayisi = " + columnCount);
        } catch (SQLException e) {
            System.out.println("metadata can not be got");
            e.getMessage();
        }
        return columnCount;
    }

    static ResultSetMetaData getResultSetMetadata() {
        try {
            resultSetMetaData = resultSet.getMetaData();
            System.out.println("metadata is got");
        } catch (SQLException e) {
            System.out.println("metadata can not be got");
            e.getMessage();
        }
        return resultSetMetaData;
    }

    /**
     * tüm kolon isimlerini liste (String) ekleme
     **/
    static List<String> getAllColumnAsList() {
        List<String> columnNameList = new ArrayList<>();
        try {
            for (int i = 1; i <= getColumnCount(); i++) {
                columnNameList.add(resultSetMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("all column names can not able to taken");
            e.getMessage();
        }
        return columnNameList;
    }

    /**
     * parametre olarak row numarası alan,
     * o rowun tüm değerlerini liste olarak dönen
     */
    static List<String> getRowDataAsList(int rowNumber) {
        List<String> rowDataList = new ArrayList<>();

        try {
            resultSet.absolute(rowNumber);
            for (int i = 1; i <= getColumnCount(); i++) {
                String cell = resultSet.getString(i);
                rowDataList.add(cell);
            }
        } catch (SQLException e) {
            System.out.println("The selected row data can not able to taken");
            e.getMessage();
        }
        return rowDataList;
    }

    /**
     * parametre olarak satır ve sütun numarası alan
     * cell datasını döndürme
     */
    public String getCellData(int rowNumber, int columnIndex) {
        String cellData = "";

        try {
            resultSet.absolute(rowNumber);
            cellData = resultSet.getString(columnIndex);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("cell data can not able to taken");
            e.getMessage();
        }
        return cellData;
    }
    /**
     * parametre olarak satır ve sütun adı alan
     * cell datasını döndürme
     */
    public String getCellData(int rowNumber, String columnLabel) {
        String cellData = "";

        try {
            resultSet.absolute(rowNumber);
            cellData = resultSet.getString(columnLabel);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            System.out.println("cell data can not able to taken");
            e.getMessage();
        }
        return cellData;
    }
}
