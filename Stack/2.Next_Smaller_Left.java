class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
        ArrayList<Integer> ans = new ArrayList<>();
        int k = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            if(st.size()==0){
                ans.add(-1);
            }
            else if(st.size()>0 && st.peek()<arr[i]){
                ans.add(st.peek());
            }
            else if(st.size()>0 && st.peek()>=arr[i]){
                while(st.size()>0 && st.peek()>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                   ans.add(-1);
                }
                else{
                    ans.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
