import java.util.*;
 //https://www.geeksforgeeks.org/count-of-substrings-having-all-distinct-characters/
class Main
{
    public static boolean checkDistinct(String s){
       boolean[] vis = new boolean[256];
       int n = s.length();
       
       boolean f1 = true;
       for(int i=0;i<n;i++){
           char ch = s.charAt(i);
           
           if(vis[ch] == true){
               f1 = false;
               return f1;
               
           }
           else{
               vis[ch] = true;
           }
       }
       
       return f1;
        
    }
    
    public static void main (String[] args)
    {
        String s = "gfg";
        int count = 0;
        boolean ans = false;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                ans = checkDistinct(s.substring(i,j));
                if(ans == true){
                    count += 1;
                }
            }
        }
        
        System.out.println(count);
        
    }
}
//tc O(n^2)
