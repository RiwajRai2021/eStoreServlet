package com.estore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estore.db.DB;
import com.estore.model.Product;

/**
 * Servlet implementation class AllProductsController
 */
@WebServlet("/AllProductsController")
public class AllProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.print("<center>");
		
		
		DB db = new DB(); 
		ArrayList<Product>products = db.fetchAllProducts();
		db.closeConnection();
		StringBuffer buffer = new StringBuffer();
		if(products.size()>0) {
		
		buffer.append("<table>"); 
		buffer.append("<tr>");
		buffer.append("<td>ID</td>");
		buffer.append("<td>CODE</td>");
		buffer.append("<td>NAME</td>");
		buffer.append("<td>PRICE</td>");
		buffer.append("</tr>");
		
		for(Product product:products) {
			buffer.append("<tr>");
			buffer.append("<td>"+product.id+"</td>");
			buffer.append("<td>"+product.code+"</td>");
			buffer.append("<td>"+product.name+"</td>");
			buffer.append("<td>"+product.price+"</td>");
			buffer.append("</tr>");
			
		}
		
		buffer.append("</table>");
		
		}else {
			buffer.append("<h3>No Products Found</h3>");
		}
				
		out.print(buffer.toString());
		out.print("</center>");
		
	}
		
}