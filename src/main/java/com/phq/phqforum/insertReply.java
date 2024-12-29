package com.phq.phqforum;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author evanredmond
 */
public class insertReply {
    
    
    //DATE, TOPIC, USER, REPLIES
        String que = "INSERT INTO responses (date, Topic, user, replies) VALUES (?, ?, ?, ?)";
    
    
        Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
        
        public  synchronized void insertIt(String date, String topic, String user, String reply) throws SQLException {
            
            try (Connection conn = getConnection()) {
                
                
                try (PreparedStatement PS2 = conn.prepareStatement(que)) {
                    
                    PS2.setString(1, date);
                    PS2.setString(2, topic);
                    PS2.setString(3, user);
                    PS2.setString(4, reply);
                    PS2.execute();
                    
                    
                }
                
            }
            
            
            
        }
    
    
}
