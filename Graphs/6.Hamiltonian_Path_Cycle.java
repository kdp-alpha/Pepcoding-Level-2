import java.util.*;

class Main{
    //* stand for hamiltonian path
    //.stands for hamiltonian cycle
   public static void hamiltonian(ArrayList<Integer>[] graph,int src,HashSet<Integer> vis,int orsrc,String psf){
       
       if(psf.length() == graph.length ){
           System.out.print(psf);
           
           boolean flag = false;
           for(int nbr: graph[src]){
               if(nbr==orsrc){
                   flag = true;
                   break;
               }
           }
           
           if(flag==true){
               System.out.println(".");
           }
           else{
               System.out.println("*");
           }
           return;
       }
       
       
       vis.add(src);
       for(int nbr:graph[src]){
           if(vis.contains(nbr)==false){
               hamiltonian(graph,nbr,vis,orsrc,psf+nbr);
           }
       }
       vis.remove(src);
       
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
       HashSet<Integer> vis = new HashSet<>();
        hamiltonian(graph,0,vis,0,0 + "");
       
      
    }
}
