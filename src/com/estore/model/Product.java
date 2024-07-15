package com.estore.model;

/*
 *  
  
  create table ProductEstore(
  	id int primary key auto increment,
  	code int, 
  	name varchar(256), 
   ) 
  
  
  */
  
 
public class Product {
	
	//attributes 
	public int id; 
	public int code; 
	public String name; 
	public int price;
	
	public Product() {
		
	}
	
	public Product(int id, int code, String name, int price) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
	

}
