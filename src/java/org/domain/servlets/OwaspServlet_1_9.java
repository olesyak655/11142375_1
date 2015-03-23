/*
 * This Servlet implements method post. (For OWASP Top 10 elements 1-9)
  */
package org.domain.servlets;

import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 *
 * @author Олеся
 */
public class OwaspServlet_1_9 extends HttpServlet {
    // Instance variables - for setting information from properties file
    private String title; 
    private String description; 
    private String impact; 
    private String scenario; 
    private String avoid; 
    private String external_resources;
    
    // This method choose a properties file for selected OWASP Top 10 element 
    // and set the informasion from the properties file to the instance variables
    public void init(HttpServletRequest request) {
        String s1=request.getParameter("Owasp"); 
        
        System.out.println("the value of Owasp is" + s1);
        String filePropertiesName = "owasp_" + s1 + ".properties";
        
        FileInputStream fis;
        Properties property = new Properties();
        
        title = ""; 
        description = ""; 
        impact = ""; 
        scenario = ""; 
        avoid = ""; 
        external_resources = ""; 
        
        try {
            
            String projectPathFull = request.getRealPath("/");
            int intPprojectPath = projectPathFull.lastIndexOf("build\\web\\");
            String projectPath = projectPathFull.substring(0,intPprojectPath-1);
            
            fis = new FileInputStream(projectPath + "\\src\\java\\"+filePropertiesName);
            property.load(fis);
 
            title = property.getProperty("title");
            description = property.getProperty("description");
            impact = property.getProperty("impact");
            scenario = property.getProperty("scenario");
            avoid = property.getProperty("avoid");
            external_resources = property.getProperty("external_resources");
            
            fis.close();
            
        } catch (IOException e) {
            System.err.println("Error: Properties file is not found");
        }
        finally {
            
        }
    } 
    
    /**
     * Processes requests for both HTTP <code>POST</code>
     * methods.
     *This method create a response with information about selected OWASP Top 10 elements
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idOwasp = request.getParameter("Owasp");
        
        // If number of selected OWASP Top 10 element is 10 - regerect to OwaspServlet_10 
        // and implement method Get
        if(idOwasp.equals("10")) {
            response.sendRedirect("OwaspServlet_10");
        }
        
        response.setContentType("text/html;charset=UTF-8");
                
        Cookie cookie = new Cookie("category", idOwasp);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        
        try (PrintWriter out = response.getWriter()) {
                        
            init(request);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"#EEE8AA\">");
           
            out.println("<a href=\"index.jsp?Owasp="+idOwasp+"\">Back</a>");
            out.println("<br>");
            out.println("<br>");
            // Set information from the instanse variables about OWASP Top 10 element to response HTML code
            out.println("<p>" + title + "</p>");
            out.println("<p>" + description + "</p>");
            out.println("<p>" + impact + "</p>");
            out.println("<p>" + scenario + "</p>");
            out.println("<p>" + avoid + "</p>");
            out.println("<p>" + external_resources + "</p>");
            
            out.println("</body>");
            out.println("</html>");
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
