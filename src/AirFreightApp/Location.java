/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part 2
 */

package AirFreightApp;
import GraphFramework.Edge;
import GraphFramework.Vertex;
import java.util.LinkedList;

/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public class Location extends Vertex{
    
    private static int count=0; 
    private int id=0;
    private String city;
    // constructor 
    public Location(String label, boolean isVisited) {
        super(label, isVisited);
         city="city "+id;
        id=count++;
    }
    @Override
    //  getter
    public String getLabel() {
        return label;
    }

    

    @Override
    //  getter
    public LinkedList<Edge> getAdglist() {
        return this.adglist;
    }

    
    @Override
    public void setAdglist(LinkedList<Edge> adglist) {
        this.adglist = adglist;
    }
    
    @Override
    public void addAdjacency(Edge edge){
        adglist.add(edge);
    }
    //for req2
    @Override
    public void setLabel (int i ){
       
       this.label="Loc"+i;
       
        
    }
   
    
    

    /**
     * This method displays information about the location vertex, including its label.
     */
    @Override
    public void displayInfo(){
        System.out.println(label+" : "+city);
    }
}

    
