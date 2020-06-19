package blackjackgui;

import java.sql.*;

/**
 * Set up and manipulation of JDBC database
 * 
 * @author BretNorton 0948797
 */
public class BlackjackDB {
    
    Connection conn;
    
    public BlackjackDB(){
        try {
            conn = DriverManager.getConnection("jdbc:derby:BlackjackUsers;  create=true");
            
            createTable();
            
            setupTable();
            
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
    
    /**
     * Check to see if 'users' table exists and if not create the table.
     */    
    public void createTable() {
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
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
    
    /**
     * Insert some sample data into the table.
     */
    public void setupTable() {
        String[] users = {"steve", "jim", "fred"};
            
        for (int i = 0; i > users.length; i++) {
            addUser(users[i]);
        }
    }
    
    /**
     * Add a new row (or user) to the table.
     * 
     * @param user 
     */
    public void addUser(String user) {
        if (!checkForDuplication(user))
        {
            try {
                Statement statement = conn.createStatement();

                String sqlUpdateTable = "insert into users values ('" + user.toLowerCase() + "',500)";

                statement.executeUpdate(sqlUpdateTable);
            } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
            }
        }
    }
    
    /**
     * Remove a row (or user) from the table.
     * 
     * @param user 
     */
    public void deleteUser(String user) {
        try {
            Statement statement = conn.createStatement();
            
            String sqlUpdateTable = "delete from users '" + user.toLowerCase() + "'";
            
            statement.executeUpdate(sqlUpdateTable);
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
    
    /**
     * Check to see if a user already exists in the database.
     * 
     * @param user the users name as a string to check.
     * @return true if user already exists.
     */
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
                System.err.println("SQL Exception: " + e.getMessage());
        }
        
        return dupeFlag;
    }
    
    /**
     * Returns users credits.
     * 
     * @param user the user's name as a string to check.
     * @return user's current credits as an integer.
     */
    public int getCredits(String user) {
        ResultSet rs = null;
        boolean dupeFlag = false;
        int credits = 0;
        
        try {
            Statement statement = conn.createStatement();
            
            rs = statement.executeQuery("select * from users where name = '" + user.toLowerCase() + "'");
            
            while (rs.next())
                credits = rs.getInt(2);
            
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
        
        return credits;
    }
    
    /**
     * Sets users credits.
     * 
     * @param credits updated credits value as an integer.
     * @param user the user to update as a String.
     */
    public void setCredits(int credits, String user) {
        try {
            Statement statement = conn.createStatement();
            
            String sqlUpdateStatement = "update users set credits = " + credits + " where name = '" + user.toLowerCase() + "'";
            
            statement.executeUpdate(sqlUpdateStatement);
        } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
