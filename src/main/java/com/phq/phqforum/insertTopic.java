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
public class insertTopic {
    
    String que = "INSERT INTO topics (topic, datePosted, numViews, numReplies, Description, Community, poster, lastPost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    
        Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
        
        public  synchronized void insertIt(String topic, String description, String community, String
                datePosted, String user) throws SQLException {
            
            try (Connection conn = getConnection()) {
                
                
                try (PreparedStatement PS2 = conn.prepareStatement(que)) {
                    
                    
                    PS2.setString(1, topic);
                    PS2.setString(2, datePosted);
                    PS2.setString(3, "0");
                    PS2.setString(4, "0");
                    PS2.setString(5, description);
                    PS2.setString(6, community);
                    PS2.setString(7, user);
                    PS2.setString(8, "n/a");
                   
                PS2.execute();
                    
                    
                }
                
            }
            
            
            
        }
    
}
