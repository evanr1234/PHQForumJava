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
public class FetchDescription {
    
     
    JsonArray JSA2;
    JsonArrayBuilder JSA3 = Json.createArrayBuilder();
     JsonArrayBuilder JSA4 = Json.createArrayBuilder();
     
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}

    
     synchronized JsonArray found(String topic) throws SQLException  {
        
           String quer = "SELECT Description FROM topics WHERE topic = ?";
   
        
        try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(quer)) {
                PS.setString(1, topic);
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
                        
                        System.out.println("here is RS: " + rs.getString(1));
                        
                            if ((rs.getString(1) == null)) {
                      JSA3.add(Json.createObjectBuilder().
                                addNull("Desc").addNull("Desc"));
                       
                      
                     }
                       
                     else {
                         
                    
                        
                        JSA3.add(Json.createObjectBuilder().add("Desc",
                                rs.getString(1)));
                        
                       
                         
                     }

                        
                    }
  
                }
                
                   JSA2 = JSA3.build();
                   System.out.println("here is JSOn String: " + JSA2);
            }
            
 
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
       
       
        return JSA2;
    }
    
}