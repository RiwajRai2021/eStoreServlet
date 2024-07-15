package com.estore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estore.db.DB;
import com.estore.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet({ "/ProductController", "/Product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ProductController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product = new Product();
		product.code = Integer.parseInt(request.getParameter("textCode"));
		product.name = request.getParameter("textName");
		product.price = Integer.parseInt(request.getParameter("textPrice"));

		System.out.println("[Product Servlet] Product Details: " + product);

		DB db = new DB();

		int result = db.addProduct(product);
		db.closeConnection();

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<center>");

		String message = "";

		if (result > 0) {
			message = product.name + " added in database successfully";
		} else {

			message = product.name + " not added in database. Please try again.";
		}

		out.print("<p>" + message + "</p>");

		out.print("</center>");

	}

}
