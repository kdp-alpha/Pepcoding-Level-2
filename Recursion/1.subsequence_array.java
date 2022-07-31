import java.util.*;
class Main{
    public static void f1(ArrayList<Integer> list,int idx,int[] arr){
       if(idx>=arr.length){
           System.out.println(list);
           return;
       }
       
       list.add(arr[idx]);
       f1(list,idx+1,arr);
       list.remove(list.size()-1);
       f1(list,idx+1,arr);
    }
    
    
    public static void main(String[] args){
        // ArrayList<Integer> list = new ArrayList<>(
        //      Arrays.asList(1,2,3));
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1,2,3};
        f1(list,0,arr);
       
        
    }
}

//tc O(2^n)
// Space Complexity: 
// O(n) , Because of the recursion stack.
