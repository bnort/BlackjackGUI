/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import java.sql.*;

/**
 *
 * @author bnort
 */
public class BlackjackDB {
    
    Connection conn;
    
    public BlackjackDB(){
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BlackjackUsers");
            
            createTable(conn);
            
            setupTable(conn);
            
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION LOL " + e.getMessage());
        }
    }
    
        
    public void createTable(Connection conn) {
        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "USERS", null);
            if (rs.next()) {
            }
            else {
                Statement statement = conn.createStatement();
                        
                String sqlCreateTable = "create table users (name varchar(50), credits integer)";
                
                statement.executeUpdate(sqlCreateTable);
            }
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION lmao " + e.getMessage());
        }
    }
    
    public void setupTable(Connection conn) {
        String[] users = {"steve", "jim", "fred"};
            
        for (int i = 0; i > users.length; i++) {
            addUser(users[i]);
        }
    }
    
    public void addUser(String user) {
        if (!checkForDuplication(user))
        {
            try {
                Statement statement = conn.createStatement();

                String sqlUpdateTable = "insert into users values ('" + user + "',500)";

                statement.executeUpdate(sqlUpdateTable);
            } catch (SQLException e) {
                System.err.println("SQL EXCEPTION rofl " + e.getMessage());
            }
        }
    }
    
    private boolean checkForDuplication(String user) {
        ResultSet rs = null;
        boolean dupeFlag = false;
        
        try {
            Statement statement = conn.createStatement();
            
            rs = statement.executeQuery("select name from users");
            
            while (rs.next())
            {
                if (user.equals(rs.getString(1)))
                    dupeFlag = true;
            }
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION onono " + e.getMessage());
        }
        
        return dupeFlag;
    }
    
    public int getCredits(String user) {
        ResultSet rs = null;
        boolean dupeFlag = false;
        int credits = 0;
        
        try {
            Statement statement = conn.createStatement();
            
            rs = statement.executeQuery("select * from users where name = '" + user + "'");
            
            while (rs.next())
                credits = rs.getInt(2);
            
        } catch (SQLException e) {
            System.err.println("SQL Expection o boi " + e.getMessage());
        }
        
        return credits;
    }
    
}
