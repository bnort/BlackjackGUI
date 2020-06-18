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
<<<<<<< HEAD
                System.err.println("SQL Exception: " + e.getMessage());
=======
            System.err.println("SQL EXCEPTION LOL " + e.getMessage());
>>>>>>> database
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
<<<<<<< HEAD
                System.err.println("SQL Exception: " + e.getMessage());
=======
            System.err.println("SQL EXCEPTION lmao " + e.getMessage());
>>>>>>> database
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

<<<<<<< HEAD
                String sqlUpdateTable = "insert into users values ('" + user.toLowerCase() + "',500)";

                statement.executeUpdate(sqlUpdateTable);
            } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
=======
                String sqlUpdateTable = "insert into users values ('" + user + "',500)";

                statement.executeUpdate(sqlUpdateTable);
            } catch (SQLException e) {
                System.err.println("SQL EXCEPTION rofl " + e.getMessage());
>>>>>>> database
            }
        }
    }
    
<<<<<<< HEAD
    public void deleteUser(String user) {
        try {
            Statement statement = conn.createStatement();
            
            String sqlUpdateTable = "delete from users '" + user.toLowerCase() + "'";
            
            statement.executeUpdate(sqlUpdateTable);
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
    
=======
>>>>>>> database
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
<<<<<<< HEAD
                System.err.println("SQL Exception: " + e.getMessage());
=======
            System.err.println("SQL EXCEPTION onono " + e.getMessage());
>>>>>>> database
        }
        
        return dupeFlag;
    }
    
    public int getCredits(String user) {
        ResultSet rs = null;
        boolean dupeFlag = false;
        int credits = 0;
        
        try {
            Statement statement = conn.createStatement();
            
<<<<<<< HEAD
            rs = statement.executeQuery("select * from users where name = '" + user.toLowerCase() + "'");
=======
            rs = statement.executeQuery("select * from users where name = '" + user + "'");
>>>>>>> database
            
            while (rs.next())
                credits = rs.getInt(2);
            
        } catch (SQLException e) {
<<<<<<< HEAD
                System.err.println("SQL Exception: " + e.getMessage());
=======
            System.err.println("SQL Expection o boi " + e.getMessage());
>>>>>>> database
        }
        
        return credits;
    }
    
<<<<<<< HEAD
    public void setCredits(int credits, String user) {
        try {
            Statement statement = conn.createStatement();
            
            String sqlUpdateStatement = "update users set credits = " + credits + " where name = '" + user.toLowerCase() + "'";
            
            statement.executeUpdate(sqlUpdateStatement);
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
=======
>>>>>>> database
}
