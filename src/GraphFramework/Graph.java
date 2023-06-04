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

import AirFreightApp.Location;
import AirFreightApp.Route;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public abstract class  Graph {
    // attributes
    protected int verticesNo ;
    protected int edgeNo ;
    protected boolean isDigraph;
    protected int incrementedge;
    protected LinkedList<Vertex> vertices =new LinkedList<> ();
    protected LinkedList<Edge> allEdges =  new LinkedList<> ();
   
    //by defult verticesNo and  edgeNo  intilize with 0 , isDigraph = false 
    public Graph() {
        this.verticesNo=0;
        this.edgeNo=0;
        this.isDigraph=false;
    }
    //constructor for  make a graph with the specific input 
    public Graph(int verticesNo, int edgeNo,boolean isDigraph ) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
       
    }
    // setter
    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }
    public void setEdges(LinkedList<Edge> edges) {
        this.allEdges = edges;
    }
    public void setVertices(LinkedList<Vertex> vertices) {
        this.vertices = vertices;
    }
   
    // getter

    public int getVerticesNo() {
        return verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public int getIncrementedge() {
        return incrementedge;
    }

    public LinkedList<Vertex> getVertices() {
        return (LinkedList<Vertex>) vertices;
    }
    
    public LinkedList<Edge> getAllEdges() {
        return allEdges;
    }
// ------------------------------------ methods ------------------------------------------------
    
     // This method generates a graph randomly, with the specified number of vertices and edges,and randomely weight
     // @param verticesNo is the number of vertices in the graph.
     // @param edgeNo  is the number of edges in the graph.
     
public void makeGraph(int verticesNo, int edgeNo, boolean isDigraph){

        this.verticesNo=verticesNo;
        this.edgeNo=edgeNo;
        this.isDigraph=isDigraph; 

         vertices.clear();// to remove any garbisch element before add any element
        allEdges.clear(); // to remove any garbisch element before add any element
        
        // instance of Random class
        Random random = new Random();
        // first generate random label 
        for (int i = 0; i < verticesNo; i++){
            // craete random number between 0 to number of vertices( randomly initializes the vertices’ labels. )
            int num = random.nextInt(verticesNo);
            // converte int random num to string 
            String label=Integer.toString(num);
           // called the createVertex to crate an location object , then add it to the vertices list 
            vertices.add(createVertex(label,false));
         // second set the label with "loc" +i  start with loc1 to locn . where n = number of node 
            vertices.get(i).setLabel(i+1);

        }


        // ensure that all vertices are connected
        for (int i = 0; i < verticesNo-1; i++) {

            // generate random edge weights between 1-20 
            int randomWeight = random.nextInt(20) + 1;
            // connect this  vertix with the random one 
             int num = random.nextInt(verticesNo);
            
            // creating edges that connects the created vertices randomly and assigning them random weights.
            //connect vertices 
            // call the addEdge method 
            addEdge(vertices.get(i), vertices.get(num), randomWeight );
        }

        // generate edges between vertices with the remaining edges
        // sub the num of the created edge from whole number of edge number 
        int remEdges = edgeNo - allEdges.size() ;
        
        // continue Enter the while loop if the num of remEdges grater than 0 
        while (remEdges>0){
            // connect random  vertix with the random one if (the twe vertices not the same and not connected already )
            
            int sourceIndex = random.nextInt(verticesNo);
            int targetIndex = random.nextInt(verticesNo);
            // get rhe random vertices 
            Vertex sourceVertex = vertices.get(sourceIndex);
            Vertex targetVertex = vertices.get(targetIndex);

            // to avoid self loops and duplicate edges
            if (sourceVertex != targetVertex && !isConnected(sourceVertex, targetVertex)) {

                // generate random weights in range 1 to 20
                
                int randomWeight = random.nextInt(20) + 1;
                // add new edge to the graph
                addEdge(sourceVertex, targetVertex, randomWeight);
                // sub thhe number of remEdges
                remEdges--;
            }

        }

    }

     /**
     * This method checks if two vertices are connected by an edge.
     * @param source The source vertex.
     * @param target The target vertex.
     * @return A boolean value indicating whether the two vertices are connected by an edge or not .
     */
    private boolean isConnected( Vertex source , Vertex target ) {
        //check if the 2 vertices not connected already 
        // check if the source vertix connecte with this target
        for (Edge edge : source.getAdglist()) {
            if(edge.getTarget()== target){
                return true;
            }
        }
        // check if the target vertix connecte with this source
        for (Edge edge : target.getAdglist()) {
            if(edge.getTarget()==source){
                return true;
            }
        }
        //if the 2 vertices not connected already 
        return false;
    }

     /* abstract mithod to create object of location in the extends class which is AFRouteMap
     * @param label The label of  vertex.
     * @param isVisited .
     * @return A vertex object (location object )
    will be oferride in subclass
    */
    
    public abstract Vertex createVertex(String  label ,boolean isVisited);
    
    /* abstract mithod to create object of route n the extends class which is AFRouteMap
     * @param weight the weight of the edge route 
     * @param source The source vertex.
     * @param target The target vertex.
     * @return A edge object (route object )
    will be oferride in subclass
    */
    public abstract Edge createEdge(Vertex source, Vertex target, int weight );  
        
    
      

    /**
     * This method reads a graph from a file, and constructs the graph accordingly.
     * @param inputfile The name of the file to read the graph from.
     * @throws FileNotFoundException If the specified file cannot be found.
     */
     public void readGraphFromFile(File inputfile) throws FileNotFoundException{// because this mithod read from file
        // create a scanner to read from file
        Scanner input = new Scanner (inputfile);
        String info="";
        // read the info from the file
        info=input.next();
            // check if the info is equals to digraph . if the graph is directed graph
            if(info.equalsIgnoreCase("digraph")){
                 // read from file 
                isDigraph= (input.nextInt()==1);// true if the input is equals to 1 ,fales if it is not  equals to 1
                verticesNo=input.nextInt();
                edgeNo=input.nextInt();
            }
        do {
               // read from file
                info = input.next();
                String info2 = input.next();
                
                Vertex v = null ;// by defult v = null
                //search if v vertix is exists already or not
                for (Vertex vert:vertices ) {
                   if(vert.getLabel().equalsIgnoreCase(info)){
                      v= vert;
                    }
                }
                Vertex u = null;// by defult u = null
                //search if u  vertix is exists already or not
                for (Vertex vert:vertices ) {
                   if(vert.getLabel().equalsIgnoreCase(info2)){
                      u= vert;
                    }
                }
                 
                Vertex source;
                Vertex target;
                if (v == null){ // if v not created yet
                    // call mithod createVertex to create a new location (vertix) 
                    source= createVertex(info,false);
                    // add to the list of vertices
                    vertices.add(source);
                }else { // if v  created already
                    source=v;
                }

                if (u==null){ // if u not created yet
                    // call mithod createVertex to create a new location (vertix) 
                    target= createVertex(info2,false);
                    // add to the list of vertices
                    vertices.add(target);
                }else{
                    target=u; // if u created already
                }
                 // specific weight 
                int weight=input.nextInt();
                 // add edge to the graph
                addEdge(source,target,weight);

            

        }while(input.hasNext()); // if the file has input 

    }
    
      /* v = source ,u = target 
      *  abstract mithod to add  line to the list
     * @param weight the weight of the edge line 
     * @param v The source vertex.
     * @param u The target vertex.
     * @return A edge object (line object )
    */
         public Edge addEdge(Vertex v , Vertex  u , int weight) {
             // create a new line with specifc information,call method createEdge
          Edge edge = createEdge(v, u, weight);
          //add the edge to list of vertix 
          v.addAdjacency(edge);
          // then add the edge to the list of edge
          allEdges.add(edge);
          incrementedge ++;
          //for undirected graph 
          if ( !(isDigraph) ){ // if(true )  it is undirected
          Edge edge2 = createEdge( u, v, weight); // so add the edge 
          u.addAdjacency(edge2);
          incrementedge ++; 
        }
        return edge ;
    } 
         
     /* void method to display the information of vertix (location)
     
     * @return void 
    */  
    public void displayInfo(){
        for (Vertex v:vertices) {
            v.displayInfo();
            for (Edge ed: v.getAdglist()) {
                System.out.print("\t");
                ed.displayInfo();
            }
        }
    }
}
        
