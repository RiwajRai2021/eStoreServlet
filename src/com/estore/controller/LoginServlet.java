package com.estore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String EMAIL = "admin@estore.com"; 
	private final String PASSWORD = "admin@123"; 
	private final String NAME = "John"; 
	private final int TOTAL_SALES = 3000; 
	 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	//get and post both can be handled by service method

	
		protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read the data from request object
		String email = request.getParameter("textEmail");
		String password = request.getParameter("textPassword");

		System.out.println("[LoginServlet] User Details: " + email + " " + password);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String message = ""; 
		
		if(email.equals(EMAIL) && password.equals(PASSWORD)) {
			
			//1. Session Tracking with Cookies
			//Creating Cookies
			
			Cookie cookie1 = new Cookie("KEY_NAME", NAME); 
			Cookie cookie2 = new Cookie("KEY_SALES", String.valueOf(TOTAL_SALES)); 
			
			//Writing Cookies
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			//2. Session Tracking with URL Rewriting 
			//Writing data in the URl directly
			String url = "Home?name="+NAME+"&sales="+TOTAL_SALES; 
			
//			message = "<p>Welcome to Home<br><a href='Home'>Click to nagivate to Home</a></p>"; 

						
			message = "<p>Welcome to Home<br><a href='"+url+"'>Click to nagivate to Home</a></p>"; 
			
			//3. Session Tracking with hidden Form Fields
			//Writing the data in the form as hidden fields
			String form = "<form action = 'Home' method ='post'>"
					+"<input type='hidden' value='"+NAME+"' name='textName'/>"
					+"<input type='hidden' value='"+TOTAL_SALES+"' name='textSales'/>"
					+"<input type='submit' value='NAVIGATE TO HOME'/>"
					+"</form><br>";  
			
			out.print(form);
			
		}else {
			
			message = "<b>Invalid Username or Password</b>";
			
			
		}
		
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome " + email + 
				"</h3><p>You Attempted Login at " + loginTimeStamp
				+ "</p><br><br>"+message+"</center>";

		
		out.print(htmlResponse);

	}

 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//super.doGet(request, response);

		// Read the data from request object

		String email = request.getParameter("textEmail");
		String password = request.getParameter("textPassword");

		System.out.println("[LoginServlet] doGet User Details: " + email + " " + password);

		response.setContentType("text/html");
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome " + email + "</h3><p>You Loggedin at " + loginTimeStamp
				+ "<br>Handled by [doGet]</p></center>";

		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String email = request.getParameter("textEmail");
		String password = request.getParameter("textPassword");

		System.out.println("[LoginServlet] doPost User Details: " + email + " " + password);

		response.setContentType("text/html");
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome " + email + "</h3><p>You Loggedin at " + loginTimeStamp
				+ "<br>Handled by [doPost]</p></center>";

		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
	}

}

/*
 * 
 * //Read the data from request object String email =
 * request.getParameter("txtEmail"); String password =
 * request.getParameter("txtPassword");
 * 
 * System.out.println("[LoginServlet] User Details: "+email+" "+password);
 * 
 * response.setContentType("text/html"); String loginTimeStamp = new
 * Date().toString(); String htmlResponse =
 * "<center><h3>Welcome "+email+"</h3><p>You Loggedin at "+loginTimeStamp+
 * "</p></center>";
 * 
 * PrintWriter out = response.getWriter(); out.print(htmlResponse);
 * 
 */
