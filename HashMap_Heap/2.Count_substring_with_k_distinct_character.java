import java.util.*;
 
class Main
{ 
    public static int check_distinct(String s,int k){
        HashMap<Character,Integer> hm = new HashMap<>();
        int len = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0) + 1);
        }
        
        if(hm.size() == k){
            int plen = s.length();
            
            if(plen > len){
                len = plen;
            }
        }
        else{
            return 0;
        }
        
        return len;
    }
    public static void main(String[] args){
        String str = "aabbcc";
        int k = 2;
        int ans = 0;
        String final_string = "";
        int n = str.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                int pans = check_distinct(str.substring(i,j),k);
                if(pans > ans){
                    ans = pans;
                   final_string = str.substring(i,j);
                }
            }
        }
        System.out.println(final_string);
    }
}
