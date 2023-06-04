/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part 2
 */
package GraphFramework;

import java.util.LinkedList;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public abstract class Vertex {
    
    protected String label;
    protected boolean isVisited;
    protected LinkedList<Edge> adglist;
    // constructor
    public Vertex(String label, boolean isVisited) {
        this.label = label;
        this.isVisited = isVisited;
         adglist  = new LinkedList<>();
        
    }
// abstract getter
    public abstract String getLabel() ;

    
    // abstract getter
    public abstract LinkedList<Edge> getAdglist() ;
    // abstract setter
  
    public abstract void setAdglist(LinkedList<Edge> adglist);
    
    public abstract void addAdjacency(Edge edge);
    //for req2
    // abstract setter
    public abstract void setLabel (int i );
     
  /**
     * This method displays information about the vertex, including its label.
     */
    public abstract void displayInfo();

 
      
}

