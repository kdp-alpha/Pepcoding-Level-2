

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];   
        return hasPath(graph,source,destination,vis);
        
       
    }
    
    public boolean hasPath(ArrayList<Integer>[] graph,int src,int dest,boolean[] vis){
       if(src==dest){
           return true;
       }
       
        vis[src] = true;
        
        for(int nbr : graph[src]){
           if(vis[nbr] == false){
               boolean path = hasPath(graph,nbr,dest,vis);
               
               if(path){
                   return true;
               }
           }
        }
        
        
        return false;
    }
}
