/*
 * This Servlet implements method Get. (For OWASP Top 10 elements 10)
 */
package org.domain.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Олеся
 */
public class OwaspServlet_10 extends HttpServlet {
    // Instance variables - for setting information from properties file 
    private String title; 
    private String description; 
    private String impact; 
    private String scenario; 
    private String avoid; 
    private String external_resources;
    
    // This method set the informasion from the properties file owasp_10.properties to the instance variables
    public void init(HttpServletRequest request) {
         
        
        String filePropertiesName = "owasp_10.properties";
        
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
        
    } 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     *  This method create a response with information aboutOWASP Top 10 elements #10
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie cookie = new Cookie("category", "10");
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
           
            out.println("<a href=\"index.jsp?Owasp=10\">Back</a>");
            out.println("<br>");
            out.println("<br>");
            // Set information from the instanse variables about OWASP Top 10 element #10 to response HTML code
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
