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



//subsequnce on string
import java.util.*;
public class MyClass {
    public static ArrayList<String> al = new ArrayList<>();
    public static void main(String args[]) {
      String str = "abc";
      helper(str,"");
      System.out.println(al);
    }
    
    public static void helper(String str,String ans){
        if(str.length()==0){
            al.add(ans);
            return;
        }
        
        helper(str.substring(1),ans + str.charAt(0));
        
        helper(str.substring(1),ans);
    }
}

//tc O(2^n)
// Space Complexity: 
// O(n) , Because of the recursion stack.
