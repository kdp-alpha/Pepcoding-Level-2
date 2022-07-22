import java.util.*;

class Main{
    
    public static boolean bfs(ArrayList<Integer>[] graph,int src,boolean[] vis){
       ArrayDeque<Integer> mq = new ArrayDeque<>();
       mq.add(src);
       
       while(mq.size()>0){
           int rm = mq.remove();
           if(vis[rm]==true){
               return true;
           }
           vis[rm] = true;
           for(int nbr:graph[rm]){
               if(vis[nbr]==false){
                   mq.add(nbr);
               }
           }
       }
       return false;
    }
   
   
   
   
   
   
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1;i<=E;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            graph[u].add(v);
            graph[v].add(u);
           
        }
        boolean[] vis = new boolean[V+1];
        
        for(int i=1;i<=V;i++){
            if(vis[i]==false){
                boolean ans = bfs(graph,i,vis);
                if(ans==true){
                    System.out.println(ans);
                    return;
                }
            }
        }
        
       System.out.println("false");
        
    }
}
