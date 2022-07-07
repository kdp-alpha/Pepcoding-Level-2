//https://www.geeksforgeeks.org/count-subarrays-total-distinct-elements-original-array/
import java.util.*;
import java.io.*;
class Main
{ 
    public static void main(String[] args){
        int[] arr = {2, 4, 4, 2, 4};
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        
        int k = hs.size();
        int count = 0;
         
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> hm = new HashSet<>();
            for(int j=i;j<arr.length;j++){
               
                for(int l=i;l<=j;l++){
                  hm.add(arr[l]);
                    
                }
                
                if(hm.size()==k){
                    count++;
                }
               
            }
        }
        System.out.println(count);
    }
}

//tc O(n^3)

class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int b) 
    { 
        int n = arr.length;
        int i = -1;
        int j = -1;
        HashSet<Integer> hs = new HashSet<>();
        for(int k=0;k<n;k++){
            hs.add(arr[k]);
        }
        
        int size = hs.size();
        
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            while(i<n-1){
                  f1 = true;
                    i++;
                hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
                
                if(hm.size()==size){
                    ans += n - i;
                    break;
                }
              
            }
            
            while(j<i){
                 f2 = true;
                j++;
                if(hm.get(arr[j])==1){
                    hm.remove(arr[j]);
                }
                else{
                    hm.put(arr[j],hm.get(arr[j])-1);
                }
                
                if(hm.size()==size){
                    ans += n-i;
                }else{
                    break;
                }
               
            }
            
            if(f1==false && f2 ==false){
                break;
            }
        }
        
        return ans;
    }
}
