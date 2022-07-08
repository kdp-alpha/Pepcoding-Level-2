//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
class Solution 
{
    public int longestkSubstr(String s, int k) 
    {
       HashMap<Character,Integer> hm=new HashMap();
       int i=-1,j=-1,maxLength=-1;
       boolean flag1,flag2;
       while(true)
       {
           flag1=false;
           flag2=false;
           
           //acquire
           while(i<s.length()-1)
           {
               flag1=true;
               
               i++;
               char ch=s.charAt(i);
               hm.put(ch,hm.getOrDefault(ch,0)+1);
               
               if(hm.size()<k)
                    continue;
                
                else if(hm.size()==k)
                {
                    int length=i-j;
                    if(length>maxLength)
                        maxLength=length;
                }
                
                else //size>k
                    break;
           }
           
           //release
           while(j<i)
           {
               flag2=true;
               
               j++;
               char ch=s.charAt(j);
               //removing the character
               if(hm.get(ch)==1)  
                    hm.remove(ch);
                else
                    hm.put(ch,hm.get(ch)-1); 
                   
                //keep removing till the size becomes k    
                if(hm.size()>k)
                    continue;
                
                else if(hm.size()==k)
                {
                    int length=i-j;
                    if(length>maxLength)
                        maxLength=length;
                }
                break;
           }
           if(flag1==false && flag2==false)
                break;
    
       }
        return maxLength;
    }
}
