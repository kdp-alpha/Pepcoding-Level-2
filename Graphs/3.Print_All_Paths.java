import java.util.*;
class Main {
   public static void addEdge(ArrayList<Integer>[] graph,int u,int v){
       graph[u].add(v);
       graph[v].add(u);
   }
   
    public static void printAllPath(ArrayList<Integer>[] graph,int src,int dest,String asf,boolean[] vis){
        if(src==dest){
            System.out.println(asf);
            return;
        }
        vis[src] = true;
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
                printAllPath(graph,nbr,dest,asf + nbr,vis);
            }
        }
        vis[src] = false;
    }
        
    public static void main(String[] args){
      int V = 7;
      ArrayList<Integer>[] graph = new ArrayList[V];
      boolean[] vis = new boolean[V];
      for(int i=0;i<V;i++){
          graph[i] = new ArrayList<>();
      }
      
      addEdge(graph,0,1);
      addEdge(graph,0,3);
      addEdge(graph,1,2);
      addEdge(graph,2,3);
      addEdge(graph,3,4);
      addEdge(graph,4,5);
      addEdge(graph,5,6);
      addEdge(graph,4,6);
      
 
        printAllPath(graph,0,6,"0",vis);
    }
}

// op
// 0123456
// 012346
// 03456
// 0346
