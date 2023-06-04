/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part 2
 */
package GraphFramework;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */

// abstract class edge
public abstract class Edge implements Comparable<Edge> {
    protected Vertex target ;
    protected Vertex source ;
    protected int weight ;
    protected Vertex parent = null ;
    
    /**
     * Constructor for the Edge class.
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     * @param weight The weight of the edge.
     */
     public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    // abstract getter
    public abstract Vertex getSource() ;
     
 // abstract setter
    public abstract void setSource(Vertex source);

    // abstract getter
    public abstract Vertex getTarget() ;

   // abstract setter
    public abstract void setTarget(Vertex target);
// abstract getter
    public abstract int getWeight() ;

    // abstract setter
    public abstract void setWeight(int weight);

    // abstract getter
    public abstract Vertex getParent() ;

    // abstract setter
    public abstract void setParent(Vertex parent) ;

    /**
     * This method displays information about the edge, including its source vertex, target vertex, and weight.
     */
    public abstract void displayInfo();

    @Override
    public abstract int compareTo(Edge that);

}

