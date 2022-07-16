//adacency list
import java.util.*;
class Main {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            System.out.println("Edges from vertix " + i + " are :");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print("->" + adj.get(i).get(j));
                
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
      int V = 7;
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
      
      for(int i=0;i<V;i++){
          adj.add(new ArrayList<>());
          
      }
      
      addEdge(adj,0,1);
      addEdge(adj,0,3);
      addEdge(adj,1,2);
      addEdge(adj,2,3);
      addEdge(adj,3,4);
      addEdge(adj,4,5);
      addEdge(adj,5,6);
      addEdge(adj,4,6);
      printGraph(adj);
    }
}
