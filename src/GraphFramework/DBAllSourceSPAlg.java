/*
 * The Group members:
 * Afnan Ali Abu Zaydan        #2105537          B0B
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

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {

    private SingleSourceSPAlg ssAlg;

    // constructore 
    public DBAllSourceSPAlg(Graph graph,SingleSourceSPAlg ssAlg){
        super(graph);
        this.ssAlg=ssAlg;
    }


    public void computeDijkstraBasedSPAlg(){

        
        double totalTime=0;
        // loop for all source node int map 
        for (int i = 0; i < graph.verticesNo; i++) {

            ssAlg.computeDijkstraAlg(i);
            totalTime+=ssAlg.getComputeTime();
            // print the shortest path for all node
            ssAlg.printInfo();
         
        }
        // print the run time 
        System.out.println("\n--------------------------------");
        System.out.println("\nTotal runtime of Dijkstra's Algorithm: "
                + totalTime + " ms.\n");


    }


}
