package com.goyav.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.goyav.model.Customer;
import com.goyav.operation.DbCustomer;
import com.goyav.utils.Tools;

/**
 * Servlet implementation class ProductView
 */
@WebServlet(name="CustomerServlet", urlPatterns =  {"/customer"} )
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn =  Tools.getStoredConnectionSQLServer(request);

		String siret = (String) request.getParameter("siret");
        Gson gson = new Gson();
        Customer customer =  new Customer();
        try {
			customer = DbCustomer.getCustomer(conn,  siret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().print(gson.toJson(customer));
        response.getOutputStream().flush();
	}

  protected void doPut(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
	 */

  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	// TODO Auto-generated method stub
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       Connection conn = Tools.getStoredConnectionSQLServer(request);
	        Gson gson = new Gson();
	        Customer bpc = gson.fromJson(response.toString(), Customer.class);

	        if (bpc.getIdentity() != null) {
	           try {
	               DbCustomer.insertCustomer(conn, bpc);
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        }
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getOutputStream().print(gson.toJson(bpc));
	        response.getOutputStream().flush();
		}
	}
