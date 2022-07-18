import java.util.*;

class Main{
    
    public static void drawTree(ArrayList<Integer>[] graph,int src,ArrayList<Integer> cmp,boolean[] vis){
        vis[src] = true;
        cmp.add(src);
        for(int nbr : graph[src]){
            if(vis[nbr]==false){
                drawTree(graph,nbr,cmp,vis);
            }
            
        }
        
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
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       for(int i=0;i<V;i++){
           if(vis[i]==false){
               ArrayList<Integer> cmp = new ArrayList<>();
               drawTree(graph,i,cmp,vis);
               res.add(cmp);
           }
       }
       int ans = 0;
       for(int i=0;i<res.size();i++){
           for(int j=i+1;j<res.size();j++){
               int count = res.get(i).size() * res.get(j).size();
               ans += count;
           }
       }
       
       System.out.println(ans);
    }
}
