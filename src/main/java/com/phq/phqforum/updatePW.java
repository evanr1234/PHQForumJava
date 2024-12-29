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
public class updatePW {
    
        Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
    
    void now(String email, String number, String pw) {
        
String quer = "UPDATE users SET password=? WHERE email=? AND ID3=?";

try (Connection conn = getConnection()) {
    
    try (PreparedStatement PS5 = conn.prepareStatement(quer)) {
         PS5.setString(1, pw);
          PS5.setString(2, email);
           PS5.setString(3, number);
        PS5.execute();
          
        
        
        
        
    }
    
    
    
    
}catch(SQLException e){
            System.out.println("SQL Exception! " + e);
        
    }
    
}}
