import java.util.*;

class Main{
    static class Pair{
        int v;
        int wt;
        Pair(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    
    static class PQpair implements  Comparable<PQpair>{
        int v;
        int aq;
        int wt;
        PQpair(int v,int aq,int wt){
            this.v = v;
            this.aq = aq;
            this.wt = wt;
        }
        
         public int compareTo(PQpair o){
             return this.wt - o.wt;
         }
    }
    
    public static void prims(ArrayList<Pair>[] graph,boolean[] vis){
        PriorityQueue<PQpair> pq = new PriorityQueue<>();
        pq.add(new PQpair(0,-1,0));
        
        while(pq.size()>0){
            PQpair rm = pq.remove();
            
            if(vis[rm.v]==true){
                continue;
            }
            vis[rm.v]=true;
            if(rm.aq != -1){
                System.out.println(rm.v +"->" + rm.aq +"@" + rm.wt);
            }
            
            for(Pair nbr:graph[rm.v]){
                if(vis[nbr.v]==false){
                    pq.add(new PQpair(nbr.v,rm.v,nbr.wt));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        ArrayList<Pair>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<E;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            graph[u].add(new Pair(v,wt));
            graph[v].add(new Pair(u,wt));
        }
        boolean[] vis = new boolean[V];
        prims(graph,vis);
    }
}
