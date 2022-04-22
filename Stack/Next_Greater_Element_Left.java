import java.util.*;
class Main
{
    /* prints element and NGE pair for
     all elements of arr[] of size n */
    public static void printNGE(int arr[], int n)
    {
        int[] ans = new int[n];
        int k = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.size()==0){
                ans[k++] = -1;
            }
            else if(st.size()>0 && st.peek()>arr[i]){
                ans[k++]= st.peek();
            }
            else if(st.size()>0 && st.peek()<arr[i]){
                while(st.size()>0 && st.peek()<arr[i]){
                   st.pop(); 
                }
                if(st.size()==0){
                    ans[k++] = -1;
                }
                else{
                    ans[k++] = st.peek();
                }
                
            }
            
            st.add(arr[i]);
            
        }
        
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
      
    public static void main(String args[])
    {
        int arr[]= {1,3,2,4};
        int n = arr.length;
    printNGE(arr, n);
        
    }
}
