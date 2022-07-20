import java.util.*;

class Main{
    
    
   public static void topologicalSort(ArrayList<Integer>[] graph,boolean[] vis,Stack<Integer> st,int src){
       
       vis[src] =true;
       
       for(int nbr:graph[src]){
           if(vis[nbr]==false)  {
                topologicalSort(graph,vis,st,nbr);
           }
       }
       st.push(src);
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
           
        }
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==false){
            topologicalSort(graph,vis,st,i);
            }
        }
        
        while(st.size()!=0){
            System.out.println(st.pop());
        }
        
    }
}
