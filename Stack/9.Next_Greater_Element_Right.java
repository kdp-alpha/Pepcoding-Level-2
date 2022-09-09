import java.util.*;
class Main{
    public static void NGE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        int k = 0;
        for(int i=n-1;i>=0;i--){
            if(st.size()==0){
                ans[k++] = -1;
            }
            
            else if(st.size()>0 && st.peek()>arr[i]){
                ans[k++] = st.peek();
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
        
        
        for(int i=n-1;i>=0;i--){
            System.out.println(ans[i]);
        }
    }
    
    
    public static void main(String[] args){
        int[] arr = {4,5,2,25};
        NGE(arr);
    }
}
