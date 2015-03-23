package org.domain.sourses;

/**
 *
 * @author Олеся
 */
import java.util.*;

public class OwaspList {
    private List<OwaspElement> owasps;
    
    // Set the list from OWASP Top 10 elements to create the Select options in the HTML page 
    public OwaspList() {
        owasps = new ArrayList<OwaspElement>();
        owasps.add( new OwaspElement(1,"A1-Injection") );
        owasps.add( new OwaspElement(2,"A2-Broken Authentication and Session Management") );
        owasps.add( new OwaspElement(3,"A3-Cross-Site Scripting (XSS)") );
        owasps.add( new OwaspElement(4,"A4-Insecure Direct Object References") );
        owasps.add( new OwaspElement(5,"A5-Security Misconfiguration") );
        owasps.add( new OwaspElement(6,"A6-Sensitive Data Exposure") );
        owasps.add( new OwaspElement(7,"A7-Missing Function Level Access Control") );
        owasps.add( new OwaspElement(8,"A8-Cross-Site Request Forgery (CSRF)") );
        owasps.add( new OwaspElement(9,"A9-Using Components with Known Vulnerabilities") );
        owasps.add( new OwaspElement(10,"A10-Unvalidated Redirects and Forwards") );
        
   }

    public List<OwaspElement> getOwasps() {
        return owasps;
    }

    public void setOwasps(List<OwaspElement> owasps) {
        this.owasps = owasps;
    }

    @Override
    public String toString() {
        return "OwaspList{" + "owasps=" + owasps + '}';
    }
    
    
}
