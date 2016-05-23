package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.util.Date;

public class UserDAO {
	public void insertData(String username, String hashPw,
            String year, String phone) throws Exception {
		
		
		    
		
		   
        System.out.println("jdbc connection");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/test", "root", "admin");
 
        try {
 
            try {
                Statement st = con.createStatement();
                
                int value = st
                        .executeUpdate("INSERT INTO info_data(userName,passWord,email,number) "
                                + "VALUES('"
                                + username
                                + "','"
                                + hashPw
                                + "','"
                                + year
                                + "','"
                                + phone
                                + "')");
                System.out.println("1 row affected" + value);
            } catch (SQLException ex) {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    
	
	public String getPassword(String username)throws Exception {
		ResultSet res=null;
		Statement state=null;
		//ActionErrors errors = new ActionErrors();
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/test", "root", "admin");
		
		String sql = "SELECT passWord FROM info_data WHERE userName = '" + username + "' ";
		String encryptedPassword = "";
		try {
			state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			res=state.executeQuery(sql);
			
			while(res.next()) {
				encryptedPassword = res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception encountered");
			e.printStackTrace();
		}
		return encryptedPassword;
	}
	
	
	public void updatePassword(String username, String newPassword)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/test", "root", "admin");
        Statement state= null;
      //Date and time format    
	    //long time = System.currentTimeMillis();
	    //java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
	    //System.out.println("Time in milliseconds :" + timestamp);
		
		try {
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		
			String sql = "UPDATE info_data SET passWord='" + newPassword + "', lastLogin='" +sqlDate+ "' WHERE userName='" + username + "'";
				state=con.createStatement();
				state.executeUpdate(sql);
				
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Password changed successfully");
		
	}
	public void displayUser(){
		
			
		}
	}
	
	
	
	
	
	
	
	
	


