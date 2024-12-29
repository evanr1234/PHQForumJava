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
public class incrementReplies {
    
                Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
    
    void inc(String topic) {
        
String quer = "UPDATE topics set numReplies=numReplies+1 WHERE topic=?";

try (Connection conn = getConnection()) {
    
    try (PreparedStatement PS5 = conn.prepareStatement(quer)) {
         PS5.setString(1, topic);
        
        PS5.execute();
          
        
        
        
        
    }
    
    
    
    
}catch(SQLException e){
            System.out.println("SQL Exception! " + e);
        
    }
    
}
    
}
