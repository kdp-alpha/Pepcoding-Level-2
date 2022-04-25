class Solution {
    public int trap(int[] arr) {
        int[] left = new int[arr.length]; 
        left[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            left[i] = Math.max(arr[i],left[i-1]);
        }
       
        for(int i=0;i<left.length;i++){
            System.out.println(left[i]);
        }
        
        
        int[] right = new int[arr.length];
        right[arr.length-1] = arr[arr.length-1];
        
        for(int i=arr.length-2;i>=0;i--){
           right[i] = Math.max(arr[i],right[i+1]);
        }
        
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int min = Math.min(left[i],right[i]) - arr[i];
            ans[i]=min;
        }
        
       
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += ans[i];
        }
        return sum;
    }
}
