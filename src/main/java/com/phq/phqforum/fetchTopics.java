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
public class fetchTopics {
    
    
    JsonArray JSA2;
    JsonArrayBuilder JSA3 = Json.createArrayBuilder();
     JsonArrayBuilder JSA4 = Json.createArrayBuilder();
     
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    }
    
    
    
    
    
       synchronized JsonArray fetchTopics2(String community) throws SQLException  {
        
           String que2 = "SELECT topic, numReplies, numViews, lastPost "
                   + "FROM topics WHERE Community = ?";

        
        try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(que2)) {
                PS.setString(1, community);
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
                        
                   
                        
                      
                        
                     if ((rs.getString(1) == null) || (rs.getString(2) == null)) {
                      JSA3.add(Json.createObjectBuilder().
                                addNull("user").addNull("replies"));
                       
                     }
                       
                     else {
                         
                    
                        
                        JSA3.add(Json.createObjectBuilder().add("topic",
                                rs.getString(1)).add("replies", rs.getString(2))
                        .add("views", rs.getString(3)).add("lastPost", rs.getString(4)));
                         
                     }
           
                        
                    }
                    
               
                    
                }
                
                     JSA2 = JSA3.build();
              
            }
            
            
            
            
            
            
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
        
       System.out.println("about to return ");
       
       for (int i = JSA2.size() - 1; i >= 0; i--) {
           
           JSA4.add(JSA2.get(i));
           
       }
        return JSA4.build();
        
    }
    
}
    

