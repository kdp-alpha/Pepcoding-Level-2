import java.util.*;

class Main{
    public static class Edge implements Comparable<Edge>{
        int v;
        int wt;
        Edge(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
         public int compareTo(Edge o){
             return this.wt - o.wt;
         }
    }
    
    public static void dijkstra(ArrayList<Edge>[] graph,boolean[] vis,int src,int dest){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(src,0));
        
        while(pq.size()>0){
            Edge rm = pq.remove();
            int vt = rm.v;
            int wt = rm.wt;
            
            if(vis[vt]==true){
                continue;
            }
            vis[vt] = true;
            
            if(vt==dest){
              System.out.println(vt + "@" + wt);
            }
            
            for(Edge nbr : graph[vt]){
                if(vis[nbr.v]==false){
                    pq.add(new Edge(nbr.v,nbr.wt + wt));
                }
            }
        }
    }
    
    
    public static void printGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            System.out.print("edges at index" + i + ":");
            for(Edge e:graph[i]){
                System.out.print(e.v + " " + e.wt + ",");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
       int V = scn.nextInt();
       int e = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
       
        
        for(int i=0;i<e;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            graph[u].add(new Edge(v,wt));
            graph[v].add(new Edge(u,wt));
        }
        boolean[] vis = new boolean[V];
          dijkstra(graph,vis,0,6);
        // printGraph(graph);
       
    }
}
