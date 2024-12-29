/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phq.phqforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author evanredmond
 */
public class deleteUser {
    
            Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
    
    void del(String email) {
        
String quer = "DELETE FROM users WHERE email=?";

try (Connection conn = getConnection()) {
    
    try (PreparedStatement PS5 = conn.prepareStatement(quer)) {
         PS5.setString(1, email);
        
        PS5.execute();
          
  
    }
 
    
}catch(SQLException e){
            System.out.println("SQL Exception! " + e);
        
    }
    
}}
