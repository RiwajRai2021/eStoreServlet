package com.estore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("textName"); 
		String email = request.getParameter("textEmail"); 
		String password = request.getParameter("textPassword"); 
		
		System.out.println("[RegisterServlet]User Details: "+email+" "+password);
		
		response.setContentType("text/html");
		String registeredTimeStamp = new Date().toString(); 
		
		String htmlResponse = "<center><h3>Thank you "+name+"</h3><p>You are Registered with email "+email+"at" +registeredTimeStamp+"</p></center>"; 
		
		PrintWriter out = response.getWriter(); 
		out.print(htmlResponse);
		
	}

}
