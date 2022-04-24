import java.util.*;
class Main
{
    public static class Pair {
    int first;
    int second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
 static Stack<Pair> st = new Stack<>();
    
    
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void printNGE(int[] arr,int n){
        //next smaller to left
        int[] left = new int[n];
        int count1 = 0;
        for(int i=0;i<n;i++){
            if(st.size()==0){
                left[count1++] = -1;
            }
            else if(st.size()>0 && st.peek().first<arr[i]){
                left[count1++] = st.peek().second;
            }
            else if(st.size()>0 && st.peek().first>= arr[i]){
                while(st.size()>0 && st.peek().first>= arr[i]){
                    st.pop();
                }
                
                if(st.size()==0){
                    left[count1++] = -1;
                    
                }
                else{
                    left[count1++] = st.peek().second;
                }
                    
            }
            
            st.add(new Pair(arr[i],i));
        }
        
       
        printArray(left);
        st.clear();
        //next smaller to right
        int[] right = new int[n];
         int count2 = 0;
        for(int i=n-1;i>=0;i--){
            
            if(st.size()==0){
                right[count2++] = arr.length;
            }
            else if(st.size()>0 && st.peek().first < arr[i]){
                right[count2++] = st.peek().second;
            }
            else if(st.size()>0 && st.peek().first>= arr[i]){
                while(st.size()>0 && st.peek().first>= arr[i]){
                    st.pop();
                }
                
                if(st.size()==0){
                    right[count2++] = arr.length;
                    
                }
                else{
                    right[count2++] = st.peek().second;
                }
                    
            }
            
            st.add(new Pair(arr[i],i));
        }
        int temp1 = 0;
	    int temp2 = right.length-1;
	    while(temp1<temp2){
	        int temp = right[temp1];
	        right[temp1] =right[temp2];
	        right[temp2] = temp;
	        temp1++;
	        temp2--;
	    }
	    printArray(right);
        
        int[] width = new int[right.length];
        for(int i=0;i<right.length;i++){
            width[i] = right[i] - left[i]-1;
        }
        
        // printArray(width);
        
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int area = width[i] * arr[i];
            if(area>max){
                max = area;
            }
        }
        
        System.out.println(max);
        
    }
        
 


  public static void main(String args[])
  {
    int arr[] = {0};
    int n = arr.length;
    printNGE(arr, n);

  }
}
