/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schoolmanagement.management.mavenproject;

import com.schoolmanagement.management.mavenproject.Model.DBConnection;
import java.sql.*;

public class DataFetcher {
    
    DataFetcher(String query){
        DBConnection db = new DBConnection();
        db.setsDBName("SchoolManagementDev");
        db.setsHostName("jdbc:mysql://localhost:3306/");
        db.setsUserName("root");
        db.setsPassword("harry");
        Connection con = connectDB(db);
    }
    
    public static void main(String args[]){
        
    }
    
    public static Connection connectDB(DBConnection db){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    db.sHostName+"/"+db.sDBName, db.sUserName, db.sPassword);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}