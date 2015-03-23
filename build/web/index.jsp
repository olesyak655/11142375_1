<%-- 
    Document   : index
    Created on : 01.03.2015, 20:33:05
    Author     : Олеся
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>

<%-- Beans is created to create list of OWASP Top 10 elements for select options --%> 
<jsp:useBean id="owaspElement" scope="request" class="org.domain.sourses.OwaspElement"/> 
<jsp:useBean id="owaspList" scope="request" class="org.domain.sourses.OwaspList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The OWASP Top 10 - 2013</title>
    </head>
    <body bgcolor="#EEE8AA">
        
        <%!  String  lastCookieValue = "1"; %>
        <%    Cookie cookies[] = request.getCookies(); 
            if (cookies!=null&&cookies.length!=0) {
                for ( Cookie cook : cookies ) {
                    if (cook.getName().equals("category")) {
                        lastCookieValue = cook.getValue();
                    }
                }
            }
        %>
        <h1 align="center" style = "margin-left: 4%; width: 90%">Welcome to OWASP Project</h1>
        <div align="center" style = "margin-left: 4%; width: 95%">
            
            <table style = "width: 80%">
                <tr>
                    <td>
                        <h4 style="margin-left: 3%;">Please Select the OWASP Top 10 - 2013 element</h4>        
                        <form name="Entry Form" method="post" action="OwaspServlet_1_9" >
                            <div>
                                <span style="margin-left: 3%;">
                                    <!-- Select is created from OWASP Top 10 elements   -->
                                    <select name="Owasp" id="owasp" > 
                                        <%  
                                            org.domain.sourses.OwaspElement element;
                                            for(int i = 0; i < owaspList.getOwasps().size(); i++) { 
                                                element = owaspList.getOwasps().get(i); 
                                                %>  
                                            <option value="<%=element.getId()%>"><%=element.getName()%></option>
                                        <%  }  %> 
                                    </select

                                </span>
                                <span style="margin-left: 3%;">
                                    <input type="submit" value="Select" name="submit" /><br/><br/>
                                </span>
                            </div>
                        </form>
                    </td>
                    <td style="padding-left: 2%;">
                        <hr>
                        <b>Get Servlet:</b> OwaspServlet_10.java - Line# 124<br>
                        <b>Post Servlet:</b> OwaspServlet_1_9.java - Line # 151<br>
                        <b>Jsp Page:</b> index.jsp <br>
                        <b>Jsp Error Page:</b>error.jsp<br>
                        <b>Jsp Declaration:</b>index.jsp - Line# 20<br>
                        <b>Jsp Expression:</b>index.jsp - Line# 43,57<br>
                        <hr>
                    </td>
                </tr>
            
            
            
            </table>
                                    
            <br><br><br>
        This button will direct to unst.jsp which will throw an exception 
        and will direct to error.jsp (Error Handling page)
        <button onclick="window.location = 'unst.jsp';">Error</button>                                
        </div>            
        
        <!Script used to set the value of the "select" tag to the value last selected by the user>
        <script>        //invokes itself
            window.SelectElement("<%=lastCookieValue%>");

            //Sets the value of owasp select tag to the value of the cookie
            function SelectElement(valueToSelect)
            {
                var element = document.getElementById('owasp');
                element.value = valueToSelect;
            }
        </script>

    </body>
    <!Displaying the information of the required methods>
    <footer style = "margin-left: 20%; margin-top: 10%; width: 60%">
    </footer>
</html>
