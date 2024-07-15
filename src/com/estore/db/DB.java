package com.estore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.estore.model.Product;

public class DB {
	
	Connection connection; 
	PreparedStatement preparedStatement; 
	
	public DB() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("[DB] Driver Loaded");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/estore","riwajrai", "password1");
			System.out.println("[DB] Connection Created");
		} catch (Exception e) {
			
			System.out.println("Something went wrong: "+ e);
		}
		
	}
	
	public int addProduct(Product product) {
		
		int result = 0; 
		try {
			
			String sql = "insert into productestore values(null,?,?,?)"; 
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.setInt(1, product.code);
			preparedStatement.setString(2,product.name);
			preparedStatement.setInt(3,product.price);
			
			result = preparedStatement.executeUpdate(); 
			
		} catch ( Exception e ) {
			// TODO: handle exception
		} 
		
		return result; 
		
	}
	
	public ArrayList<Product>fetchAllProducts(){
		ArrayList<Product>products = new ArrayList<Product>();
		
		try {
			
			String sql = "Select * From ProductEstore"; 
			preparedStatement = connection.prepareStatement(sql); 
			
			ResultSet set = preparedStatement.executeQuery(); 
			while(set.next()) {
				Product product = new Product(); 
				product.id = set.getInt(1);
				product.code = set.getInt(2); 
				product.name = set.getString(3); 
				product.price = set.getInt(4); 
				
				products.add(product);
			}
			
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		
		return products; 
		
		
	}
	
	public void closeConnection() {
		
		try {
			
			connection.close(); 
			System.out.println("[DB] Connection to DB Closed");
			
		} catch (Exception e) {
			
		}
	}
	

}
