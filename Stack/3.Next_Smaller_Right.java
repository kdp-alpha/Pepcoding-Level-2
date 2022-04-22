class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> st = new Stack<>();
	    int[] ans = new int[n];
	    int k = 0;
	    for(int i = n-1;i>=0;i--){
	        if(st.size()==0){
	            ans[k++] = -1;
	        }
	        else if(st.size()>0 && st.peek()<arr[i]){
	            ans[k++] = st.peek();
	        }
	        else if(st.size()>0 && st.peek()>=arr[i]){
	            
	            while(st.size()>0 && st.peek()>=arr[i]){
	                st.pop();
	            }
	            if(st.size()==0){
	                ans[k++] = -1;
	            }
	            else{
	                ans[k++] = st.peek();
	            }
	            
	        }
	        st.push(arr[i]);
	    }
	    
	    int temp1 = 0;
	    int temp2 = ans.length-1;
	    while(temp1<temp2){
	        int temp = ans[temp1];
	        ans[temp1] =ans[temp2];
	        ans[temp2] = temp;
	        temp1++;
	        temp2--;
	    }
	    
	    return ans;
	} 
}
