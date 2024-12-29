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
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author evanredmond
 */
public class userFound {
    
     
   JsonArray JSA3;
    JsonArrayBuilder JSA4 = Json.createArrayBuilder();
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}

    
     synchronized String found(String user, String PW, BCryptPasswordEncoder PE) throws SQLException  {
        
           String quer = "SELECT password, EmailConfirmed FROM users WHERE username=?";
    
       String PWE = PE.encode(PW);
               try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(quer)) {
                PS.setString(1, user);
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
 
                     if ((PE.matches(PW,rs.getString(1))
                             && (Integer.parseInt(rs.getString(2))== 1))
                             
                             ) {
                  
                        JSA4.add(Json.createObjectBuilder().add("user",
                                rs.getString(1)));
                      
                        return "Success" + "-" + user + "+";
                       
                     }
                       
               
           
                        
                    }
                    
               
                    
                }
                
                     JSA3 = JSA4.build();
                   
            }
            
            
            
            
            
            
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
       
       
        return "Failure";
    }
    
}
