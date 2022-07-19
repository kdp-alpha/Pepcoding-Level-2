import java.util.*;

class Main{
     public static int min = Integer.MAX_VALUE;
   public static void dfs(ArrayList<Integer>[] graph,int src,int dest,boolean[] vis,String psf){
       if(src==dest){
          min = Math.min(min,psf.length()-1);
           return;
       }
       
       vis[src] = true;
       
       for(int nbr:graph[src]){
           if(vis[nbr]==false){
               dfs(graph,nbr,dest,vis,psf + nbr);
           }
       }
     
       vis[src] = false;
       
       
   }
 
   
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
       ArrayList<Integer>[] graph = new ArrayList[V];
       
       int ed = scn.nextInt();
       
       for(int i=0;i<V;i++){
           graph[i] = new ArrayList<>();
       }
       
       for(int i=0;i<ed;i++){
           int u = scn.nextInt();
           int v = scn.nextInt();
           graph[u].add(v);
           graph[v].add(u);
       }
       
      
     boolean[] vis = new boolean[V];
     ArrayList<Integer> cmp = new ArrayList<>();
    String psf = "0";
      dfs(graph,0,6,vis,psf);
      
      System.out.println(min);
    }
}
