import java.util.*;

class Main{
    
    public static boolean dfs(ArrayList<Integer>[] graph,int src,int parent,boolean[] vis){
        vis[src]=true;
        
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
                if(dfs(graph,nbr,src,vis)==true) return true;
            }else if(nbr!=parent){
                return true;
            }
        }
        return false;
    }
   
   
   
   
   
   
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<E;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            graph[u].add(v);
            graph[v].add(u);
           
        }
        boolean[] vis = new boolean[V];
        boolean ans = false;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                ans = dfs(graph,i,-1,vis);
                if(ans==true){
                    System.out.println(ans);
                }
            }
        }
        
       System.out.println(ans);
        
    }
}
