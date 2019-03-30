package com.goyav.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.goyav.model.Consent;
import com.goyav.model.CustomerConsent;
import com.goyav.operation.DbConsent;
import com.goyav.utils.Tools;

/**
 * Servlet implementation class ConsentServlet
 */
@WebServlet("/consent")
public class ConsentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       Connection conn = Tools.getStoredConnectionSQLServer(request);
			String siret = (String) request.getParameter("siret");
	        Gson gson = new Gson();
			CustomerConsent consent = new CustomerConsent();

			try {
				consent = DbConsent.getConsent(conn,siret);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getOutputStream().print(gson.toJson(consent));
	        response.getOutputStream().flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       Connection conn = Tools.getStoredConnectionSQLServer(request);
	        Gson gson = new Gson();
	        Consent consent = gson.fromJson(response.toString(), Consent.class);

	        if (consent.getSiret() != null) {
	           try {
	               DbConsent.insertConsent(conn, consent);
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        }
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getOutputStream().print(gson.toJson(consent));
	        response.getOutputStream().flush();
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       Connection conn = Tools.getStoredConnectionSQLServer(request);
	        Gson gson = new Gson();
	        Consent consent = gson.fromJson(response.toString(), Consent.class);

	        if (consent.getSiret() != null) {
	           try {
	               DbConsent.updateConsent(conn, consent);
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        }
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getOutputStream().print(gson.toJson(consent));
	        response.getOutputStream().flush();

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
