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
import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {


   private Node[] allNodes;
    private Set<Node> settledNodes;


    private Node sourceNode;
    private double computeTime=0;

    /**
     * Constructor for the KruskalAlg class.
     * @param graph The graph to find the minimum spanning tree.
     */
    public SingleSourceSPAlg(Graph graph){
        super(graph);
        Node.resetCount();
        allNodes = new Node[graph.verticesNo];
        for (int i = 0; i < graph.verticesNo; i++) {
            allNodes[i] = new Node(graph.getVertices().get(i), null, Integer.MAX_VALUE);
        }
    }

    public Node[] getAllNodes() {
        return allNodes;
    }

    public double getComputeTime() {
        return computeTime;
    }

    public void computeDijkstraAlg(int source){

        // Record the start time of the algorithm
        double startTime = System.currentTimeMillis();

        // Create a ِArray of all nodes in the graph, initialize their keys to infinity and parent vertices to null
        // the node who has start vertex, its key = 0
        prepareNewCompute();
        sourceNode=allNodes[source];
        sourceNode.setKey(0);


        this.settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(sourceNode);


        while (unsettledNodes.size() != 0) {

            Node currentNode = getLowestKeyNode(unsettledNodes);

            unsettledNodes.remove(currentNode);

            for (Edge adjacency : currentNode.getVertex().getAdglist()) {
                Node adjacentNode = findNode(adjacency.getTarget(),allNodes);
                int edgeWeight = adjacency.getWeight();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinKey(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }

            settledNodes.add(currentNode);
        }

        // Record the finish time of the algorithm
        double finishTime = System.currentTimeMillis();

        // Calculate compute time consumed by the algorithm
        computeTime=finishTime - startTime;

    }

    public void printInfo(){
        System.out.println("\n--------------------------------");
        //The starting point location is A
        //The routes from location A to the rest of the locations are:
        String sourceLabel=sourceNode.getVertex().getLabel();
        System.out.println("The starting point location is " +sourceLabel);
        System.out.println("\nThe routes from location "+sourceLabel+
                " to the rest of the locations are:\n");

        if(sourceNode.getVertex().getAdglist().isEmpty()){
            System.out.println("❌ can't find route from this location.");
            return;
        }

        //loc. A: city 5 – loc. B: city 2 – loc. C: : city 8– loc. D: : city 1 --- route length: 15
        for (Node n : settledNodes) {

            for(Node s: n.getShortestPath()){
                System.out.print("loc. " + s.getVertex().label + ": city " + s.getId() + " – ");
            }

            if(n!=sourceNode) {
                // where key = sum of wiehgt for shortest 
                System.out.println("loc. " + n.getVertex().label + ": city " + n.getId() + " --- route length: " + n.getKey());
            }
        }
    }

    public void prepareNewCompute(){
        for (int i = 0; i < allNodes.length; i++) {
            allNodes[i].clearValues();
        }
    }

    private static Node getLowestKeyNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeKey = node.getKey();
            if (nodeKey < lowestDistance) {
                lowestDistance = nodeKey;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * This method finds the node in a list of nodes that corresponds to a given vertex.
     * @param vertex The given vertex.
     * @param nodes The list of nodes.
     * @return The node that corresponds to the given vertex.
     */
    private Node findNode (Vertex vertex, Node[] nodes){
        for (Node selectedNode : nodes) {
            if (vertex == selectedNode.getVertex()) {
                return selectedNode;
            }
        }
        return null;
    }

    private static void calculateMinKey(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        int sourceKey = sourceNode.getKey();
        if (sourceKey + edgeWeigh < evaluationNode.getKey()) {
            evaluationNode.setParent(sourceNode.getVertex());
            evaluationNode.setKey(sourceKey + edgeWeigh);
            ArrayList<Node> shortestPath = new ArrayList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}



/**
 * This class represents a node in the MST algorithm, which contains a vertex, its parent vertex, and its key value.
 */
class Node implements Comparable<Node>{
    private static int count=0;
    private int id;
    private Vertex vertex;
    private Vertex parent;
    private int key;

    private ArrayList<Node> shortestPath = new ArrayList<>();
    /**
     * Constructor for the Node class.
     * @param vertex The vertex of the node.
     * @param parent The parent vertex of the node.
     * @param key The key value of the node.
     */
    Node(Vertex vertex,Vertex parent, int key){
        this.vertex=vertex;
        this.parent=parent;
        this.key=key;
        id=count++;
    }


// ---------------- Getter and Setter Methods ------------------

    public Vertex getVertex() {
        return vertex;
    }
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
    public Vertex getParent() {
        return parent;
    }
    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public int getId() {
        return id;
    }
    public static void resetCount(){
        count=0;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(ArrayList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
//    public void setShortestPath(List<Node> shortestPath) {
//        this.shortestPath = shortestPath;
//    }

    public void clearValues(){
        key= Integer.MAX_VALUE;
        parent=null;
        shortestPath.clear();
    }


    @Override
    public int compareTo(Node o) {
        return this.key - o.getKey();
    }
}