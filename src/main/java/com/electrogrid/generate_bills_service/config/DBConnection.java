//package com.electrogrid.generate_bills_service.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static String dbhost = "jdbc:mysql://localhost:3306/electrogrid_db?useSSL=false";
//    private static String username = "root";
//    private static String password = "990219";
//    private static Connection conn;
//
//    @SuppressWarnings("finally")
//    public static Connection createNewDBconnection() {
//        try  {
//            conn = DriverManager.getConnection(
//                    dbhost, username, password);
//        } catch (SQLException e) {
//            System.out.println("Cannot create database connection");
//            e.printStackTrace();
//        } finally {
//            //For testing
//            System.out.println("Successfully connected");
//            return conn;
//        }
//    }
//}
