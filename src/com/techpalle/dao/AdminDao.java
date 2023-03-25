package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao
{
	private static final String dburl="jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUserName="root";
	private static final String dbPassword="abhi";
	
	private static Connection con =null;
	private static PreparedStatement ps  =null;
	private static Statement stm  =null;
	private static ResultSet rs =null;
	private static final String adminQuery = "select *  from store_admin where username=? and password=?";
	
	
	public static boolean  validateAdmin(String username,String password) {
	
		boolean b=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl, dbUserName, dbPassword);
			ps=con.prepareStatement(adminQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			b=rs.next();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		
		return b;
	}

	
	
}

	
