
package org.domain.sourses;

import java.util.Objects;

/**
 * 
 * @author Олеся
 */
public class OwaspElement {
    
    private int id;
    private String name;
        
    public OwaspElement(){
       
    }
    
    public OwaspElement(int id, String name){
       this.id = id;
       this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OwaspElement other = (OwaspElement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "OwaspElement{" + "id=" + id + ", name=" + name + '}';
    }
    
}
