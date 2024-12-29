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
public class updateTopicDate {
    
                Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
    
    void update(String date, String topic) {
        
String quer = "UPDATE topics SET lastPost=? WHERE topic=?";

try (Connection conn = getConnection()) {
    
    try (PreparedStatement PS5 = conn.prepareStatement(quer)) {
        
        PS5.setString(1, date );
         PS5.setString(2, topic);
        
        PS5.execute();
        
    }
    
    
    
    
}catch(SQLException e){
            System.out.println("SQL Exception! " + e);
        
    }
    
}
    
}