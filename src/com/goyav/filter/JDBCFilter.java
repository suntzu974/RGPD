package com.goyav.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.goyav.connection.ConnectionUtils;
import com.goyav.utils.Tools;


/**
 * Servlet Filter implementation class JDBCFilter
 */
@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {

    /**
     * Default constructor. 
     */
    public JDBCFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	// Check the target of the request is a servlet?
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        // 
        // Servlet Url-pattern: /spath/*
        // 
        // => /spath
        String servletPath = request.getServletPath();
        // => /abc/mnp
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            // => /spath/*
            urlPattern = servletPath + "/*";
        }
 
        
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();
 
        // Collection of all servlet in your Webapp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
 
        // Only open connections for the special requests.
        // (For example, the path to the servlet, JSP, ..)
        // 
        // Avoid open connection for commons request.
        // (For example: image, css, javascript,... )
        // 
        if (this.needJDBC(req)) {
 
            System.out.println("Open Connection for: " + req.getServletPath());
            Connection sqlserver = null;
            Connection conn = null;
            try {
                // Create a Connection.
                //conn = ConnectionUtils.getConnection();
                sqlserver = ConnectionUtils.getSQLServerConnection();
                // Set outo commit to false.
                //conn.setAutoCommit(false);
                sqlserver.setAutoCommit(false);
 
                // Store Connection object in attribute of request.
                //Tools.storeConnection(request, conn);
                Tools.storeConnectionSQLServer(request, sqlserver);
 
                // Allow request to go forward
                // (Go to the next filter or target)
                chain.doFilter(request, response);
 
                // Invoke the commit() method to complete the transaction with the DB.
                //conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
//                ConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
        }
        // With commons requests (images, css, html, ..)
        // No need to open the connection.
        else {
            // Allow request to go forward
            // (Go to the next filter or target)
        	  chain.doFilter(request, response);
        }
    }
}
