class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<arr.length;i++){
    	    st.add(i);
    	}
    	
    	while(st.size()>=2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(arr[i][j]==1){
    	        //i = j ko jaanta hai so wo celebrity nhi hai so j ko push krdo stack main
    	        st.add(j);
    	   }
    	   else{
    	       st.push(i);
    	   }
    	}
    	
    	int pot = st.pop();
    	for(int i=0;i<arr.length;i++){
    	    if(i!=pot){
    	        if(arr[i][pot]==0 || arr[pot][i]==1){
    	            return -1;
    	        }
    	    }
    	}
    	
    	return pot;
    }
}
