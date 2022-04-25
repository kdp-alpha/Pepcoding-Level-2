class MinStack {
    
    Stack<Integer> st = new Stack<>();
    Stack<Integer> sst = new Stack<>();
  
    public void push(int val) {
        st.add(val);
        if(sst.size()==0 || val<=sst.peek()){
            sst.add(val);
        }
    }
    
    public void pop() {
        if(st.size()==0){
            return;
        }
        int ans = st.pop();
        if(ans==sst.peek()){
            sst.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(sst.size()==0){
            return -1;
        }
        return sst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
