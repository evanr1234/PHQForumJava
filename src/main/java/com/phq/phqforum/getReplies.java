
package com.phq.phqforum;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.json.*;

/**
 *
 * @author evanredmond
 */
public class getReplies {
    
   JsonArray JSA;
    JsonArrayBuilder JSA1 = Json.createArrayBuilder();
    JsonArrayBuilder JSA5 = Json.createArrayBuilder();
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}

    
     synchronized JsonArray getReplies2(String topic) throws SQLException  {
        
           String quer = "SELECT user, replies FROM responses WHERE Topic = ?";
           
        try (Connection conn = getConnection()) {
          
            try (PreparedStatement PS = conn.prepareStatement(quer)) {
                PS.setString(1, topic);
              
                try (ResultSet rs = PS.executeQuery()) {
                  
                    while (rs.next()) {
                                                
                     if ((rs.getString(1) == null) || (rs.getString(2) == null)) {
                      JSA1.add(Json.createObjectBuilder().
                                addNull("user").addNull("replies"));
                       
                     }
                       
                     else {
                         
                    
                        
                        JSA1.add(Json.createObjectBuilder().add("user",
                                rs.getString(1)).add("replies", rs.getString(2)));
                         
                     }
           
                        
                    }
                    
               
                    
                }
                
                     JSA = JSA1.build();
               
            }
            
            
            
            
            
            
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
        
        
          for (int i = JSA.size() - 1; i >= 0; i--) {
          
           JSA5.add(JSA.get(i));
           
       }
        return JSA5.build();
        
    }
    
}
