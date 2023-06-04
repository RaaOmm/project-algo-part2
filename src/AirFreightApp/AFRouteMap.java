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
import GraphFramework.Graph;
import GraphFramework.Vertex;

/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public class AFRouteMap extends Graph {
    /**
     * This method creates a new location vertex with the given label.
     * @param label The label of the location.
      * @param isVisited .
     * @return A vertex object (location object )
    */
    @Override
    public Vertex createVertex(String label ,boolean isVisited){
        return new Location(label , isVisited ); // return a new location vertex with the given label
    }
 
    /**
     * This method creates a new route edge between the given location vertices with the given weight.
     *
     * @param source The source location vertex of the route.
     * @param target The target location vertex of the route.
     * @param weight The original weight of the route.
     * @return A edge object (route object )
    */
     
     @Override
    public  Edge createEdge(Vertex source, Vertex target, int weight ){
        return new Route(source,target ,weight ); // return a new Route edge between the given location vertices.
    }

}
