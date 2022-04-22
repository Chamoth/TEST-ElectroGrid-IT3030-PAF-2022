package com.electrogrid.generate_bills_service.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.electrogrid.generate_bills_service.config.DBConnection;
import com.electrogrid.generate_bills_service.model.Bills;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    private static Statement stmt;
    private static ResultSet results;

    public static void main(String[] args) {

        String sql_select = "Select * From student_info";

        try(Connection conn = DBConnection.createNewDBconnection()){

            stmt = conn.createStatement();
            results = stmt.executeQuery(sql_select);

            List<Bills> studentsList = new ArrayList<Bills>();

            while (results.next()) {

                Bills stdObject = new Bills();

                stdObject.setId(Integer.valueOf(results.getString("id")));
                stdObject.setName(results.getString("name"));
                stdObject.setAddress(results.getString("Address"));
                stdObject.setCourse_code(results.getString("course_code"));

                studentsList.add(stdObject);
            }

            ObjectMapper mapper = new ObjectMapper();
            String JSONOutput = mapper.writeValueAsString(studentsList);
            System.out.println(JSONOutput);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
