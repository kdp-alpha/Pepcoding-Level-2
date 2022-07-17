import java.util.*;

class Main{
    public static class Edge{
        int v;
        int wt;
        Edge(int v,int wt){
            this.v = v;
            this.wt = wt;
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
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        Scanner scn = new Scanner(System.in);
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        int e = 8;
        
        for(int i=0;i<e;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            graph[u].add(new Edge(v,wt));
            graph[v].add(new Edge(u,wt));
        }
        printGraph(graph);
    }
}
