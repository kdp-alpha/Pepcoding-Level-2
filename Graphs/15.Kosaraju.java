import java.util.*;
//kosaraju strongly connected components in directed graph
class Main{
    public static void randomorderDfs(ArrayList<Integer>[] graph,Stack<Integer> st,boolean[] vis,int src){
        vis[src] = true;
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
                randomorderDfs(graph,st,vis,nbr);
            }
        }
        st.push(src);
    }
    
     public static void Dfs(ArrayList<Integer>[] graph,boolean[] vis,int src){
        vis[src] = true;
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
              Dfs(graph,vis,nbr);
            }
        }
       
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
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                randomorderDfs(graph,st,vis,i);
            }
        }
        
        ArrayList<Integer>[] reversegraph = new ArrayList[V];
        for(int i=0;i<V;i++){
            reversegraph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<V;i++){
            ArrayList<Integer> list = graph[i];
            for(int nbr:list){
                reversegraph[nbr].add(i);
            }
        }
        int ans = 0;
        vis = new boolean[V];
        while(st.size()>0){
            int rm = st.pop();
            if(vis[rm]==false){
                Dfs(reversegraph,vis,rm);
                ans++;
            }
        }
        
        System.out.println(ans);
    }
}
