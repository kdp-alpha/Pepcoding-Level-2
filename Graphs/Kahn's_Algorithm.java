import java.util.*;

class Main{
    
     public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[V+1];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<E;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            graph[u].add(v);
        }
        
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int nbr:graph[i]){
                indegree[nbr]++;
            }
        }
        
        ArrayDeque<Integer> mq = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                mq.add(i);
            }
        }
        int idx = 0;
        int[] ans = new int[V];
        while(mq.size()>0){
            int rm = mq.remove();
            
            ans[idx++] = rm;
            
            for(int nbr: graph[rm]){
                indegree[nbr]--;
                
                if(indegree[nbr]==0){
                    mq.add(nbr);
                }
            }
        }
        
        if(idx==V){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i]);
            }
        }
    }
}
