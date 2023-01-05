package com.krafttech.jdbc_test;

public class Test_JCDB_Local {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DESKTOP-SG4C4O2;encrypt=true;trustServerCertificate=true;";
        String userName = "sa";
        String password ="Mpxja261";
        String query="SELECT category_id, category_name FROM product.category";
    }
}
