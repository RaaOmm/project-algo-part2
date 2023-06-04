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
import java.util.LinkedList;

public abstract class ShortestPathAlgorithm {
    // The graph for which the MST needs to be generated
    protected Graph graph;

    // The resulting minimum spanning tree
    protected LinkedList<Edge> MSTresultList = new LinkedList<>();

    /**
     * Constructor for the ShortestPathAlgorithm class.
     * @param graph The graph for which the MST needs to be generated
     */
    public ShortestPathAlgorithm(Graph graph){
        this.graph = graph;
    }

   
            
}
