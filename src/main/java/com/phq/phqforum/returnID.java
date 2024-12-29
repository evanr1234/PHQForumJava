/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phq.phqforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author evanredmond
 */
public class returnID {

    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}

    
     synchronized String found(String user) throws SQLException  {
        
           String quer = "SELECT ID3 FROM users WHERE email = ?";
    
    
        
       System.out.println("about to try to match user");
        
        try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(quer)) {
                PS.setString(1, user);
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
                        return rs.getString(1);
    
                    }
  
                }
     
            }
  
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
       
       
        return "Error";
    }
    
}
