package com.goyav.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.goyav.model.Stock;
import com.goyav.operation.DbStock;
import com.goyav.utils.Tools;

/**
 * Servlet implementation class AllConsentServet
 */
@WebServlet("/stocks")
public class AllStocksServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllStocksServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn =  Tools.getStoredConnectionSQLServer(request);
        Gson gson = new Gson();

		List<Stock> list = null;
		try {
			list = DbStock.queryStocksForSofarem(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().print(gson.toJson(list));
        response.getOutputStream().flush();

	}

}
