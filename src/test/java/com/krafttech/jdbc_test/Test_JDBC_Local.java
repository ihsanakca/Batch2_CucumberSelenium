package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Local {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=calısmaData;encrypt=true;trustServerCertificate=true";
        String userName = "sa";
        String password ="Mpxja261";
        String query="SELECT TOP (200) customer_1.state, SUM(sale.order_item.quantity) AS toplam, product.brand.brand_name\n" +
                "FROM     product.brand INNER JOIN\n" +
                "                  product.product ON product.brand.brand_id = product.product.brand_id INNER JOIN\n" +
                "                  sale.customer INNER JOIN\n" +
                "                  sale.customer AS customer_1 ON sale.customer.customer_id = customer_1.customer_id INNER JOIN\n" +
                "                  sale.orders ON sale.customer.customer_id = sale.orders.customer_id AND customer_1.customer_id = sale.orders.customer_id INNER JOIN\n" +
                "                  sale.order_item ON sale.orders.order_id = sale.order_item.order_id AND sale.orders.order_id = sale.order_item.order_id AND sale.orders.order_id = sale.order_item.order_id AND \n" +
                "                  sale.orders.order_id = sale.order_item.order_id INNER JOIN\n" +
                "                  sale.orders AS orders_1 ON sale.customer.customer_id = orders_1.customer_id AND sale.customer.customer_id = orders_1.customer_id AND sale.customer.customer_id = orders_1.customer_id AND \n" +
                "                  sale.customer.customer_id = orders_1.customer_id AND customer_1.customer_id = orders_1.customer_id AND customer_1.customer_id = orders_1.customer_id AND customer_1.customer_id = orders_1.customer_id AND \n" +
                "                  customer_1.customer_id = orders_1.customer_id AND sale.order_item.order_id = orders_1.order_id AND sale.order_item.order_id = orders_1.order_id AND sale.order_item.order_id = orders_1.order_id AND \n" +
                "                  sale.order_item.order_id = orders_1.order_id INNER JOIN\n" +
                "                  sale.staff ON sale.orders.staff_id = sale.staff.staff_id AND sale.orders.staff_id = sale.staff.staff_id AND sale.orders.staff_id = sale.staff.staff_id AND sale.orders.staff_id = sale.staff.staff_id AND orders_1.staff_id = sale.staff.staff_id AND \n" +
                "                  orders_1.staff_id = sale.staff.staff_id AND orders_1.staff_id = sale.staff.staff_id AND orders_1.staff_id = sale.staff.staff_id INNER JOIN\n" +
                "                  sale.store ON sale.orders.store_id = sale.store.store_id AND sale.orders.store_id = sale.store.store_id AND sale.orders.store_id = sale.store.store_id AND sale.orders.store_id = sale.store.store_id AND \n" +
                "                  orders_1.store_id = sale.store.store_id AND orders_1.store_id = sale.store.store_id AND orders_1.store_id = sale.store.store_id AND orders_1.store_id = sale.store.store_id AND sale.staff.store_id = sale.store.store_id AND \n" +
                "                  sale.staff.store_id = sale.store.store_id AND sale.staff.store_id = sale.store.store_id AND sale.staff.store_id = sale.store.store_id INNER JOIN\n" +
                "                  product.stock ON sale.store.store_id = product.stock.store_id AND sale.store.store_id = product.stock.store_id AND sale.store.store_id = product.stock.store_id AND sale.store.store_id = product.stock.store_id AND \n" +
                "                  sale.store.store_id = product.stock.store_id ON product.product.product_id = sale.order_item.product_id AND product.product.product_id = sale.order_item.product_id AND product.product.product_id = sale.order_item.product_id AND \n" +
                "                  product.product.product_id = sale.order_item.product_id AND product.product.product_id = product.stock.product_id AND product.product.product_id = product.stock.product_id AND \n" +
                "                  product.product.product_id = product.stock.product_id AND product.product.product_id = product.stock.product_id AND product.product.product_id = product.stock.product_id\n" +
                "GROUP BY customer_1.state, product.brand.brand_name";


        //DESKTOP-SG4C4O2
        try (Connection connection= DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet  resultSet = statement.executeQuery(query);
        )
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());
            resultSet.next();
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

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
