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

/**
 *
 * @author evanredmond
 */
public class fetchCommunities {
    
    
    JsonArray JSA2;
    JsonArrayBuilder JSA3 = Json.createArrayBuilder();
     JsonArrayBuilder JSA4 = Json.createArrayBuilder();
     
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    }
    
    
    
    
    
       synchronized JsonArray Fetch() throws SQLException  {
        
           String que2 = "SELECT id, topics, lastPost "
                   + "FROM communities";
    
        try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(que2)) {
             
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
   
                     if ((rs.getString(1) == null) || (rs.getString(2) == null)) {
                      JSA3.add(Json.createObjectBuilder().
                                addNull("user").addNull("replies"));
                       
                     }
                       
                     else {
                         
                    
                        
                        JSA3.add(Json.createObjectBuilder().add("communities",
                                rs.getString(1)).add("topics", rs.getString(2))
                        .add("lastPost", rs.getString(3)));
                         
                     }
           
                        
                    }
                    
               
                    
                }
                
                     JSA2 = JSA3.build();
               
            }
            
            
            
            
            
            
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
        
      
       
       for (int i = JSA2.size() - 1; i >= 0; i--) {
           
           JSA4.add(JSA2.get(i));
           
       }
        return JSA4.build();
        
    }
    
}