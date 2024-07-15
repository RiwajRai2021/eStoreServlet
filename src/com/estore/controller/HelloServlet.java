package com.estore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet({ "/HelloServlet", "/Home", "/Welcome" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		System.out.println("[HelloServlet] - init executed");
		String url = config.getInitParameter("url"); 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[HelloServlet] - service executed");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String htmlResponse = "<center><h3>Welcome to Home Admin</h3>"
				+ "<p>Request Served at "+new Date()+"</p>"
				+"<p><a href = 'add-product.html'>ADD PRODUCTS</a></p>";
		out.print(htmlResponse);

		/*
		//1.Session Tracking with Cookies
		//Reading Cookies
		
		out.print("<p>Cookies Data</p>");
		
		Cookie[] array = request.getCookies(); 
		for(Cookie cookie : array) {
			out.print("<p>" +cookie.getName()+"- "+cookie.getValue()+"</p>");
		}
		
		//2. Session Tracking with URL ReWritting
		// Reading Data from URL 
		
		String name = request.getParameter("name"); 
		String sales = request.getParameter("sales"); 
		
		out.print("<p><b>URL ReWriting Data</b></p>");
		out.print("<p>NAME: "+name+" | SALES: "+sales+"</p>");
		
		*/
		
		
		out.print("</center>");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();

		System.out.println("[HelloServlet] - destroy executed");
	}

}
