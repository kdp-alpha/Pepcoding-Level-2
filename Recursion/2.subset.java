import java.util.*;
public class MyClass {
    public static void main(String args[]) {
       List<List<Integer>> li = new ArrayList<>();
       int[] arr = {1,2,3};
       helper(arr,li,new ArrayList<>(),0);
       System.out.println(li);
    }
    
    public static void helper(int[] arr,List<List<Integer>> li,List<Integer> te,int idx){
        if(idx == arr.length){
            List<Integer> temp = new ArrayList<>(te);
            li.add(temp);
            return;
        }
        
        te.add(arr[idx]);
        helper(arr,li,te,idx+1);
        te.remove(te.size() - 1);
        helper(arr,li,te,idx+1);
    }
}
