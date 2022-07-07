public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int n = nums.length;
        int count = 0;
        int ans = 0;
        int j = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }

            while(count>1){
                j++;
                if(nums[j]==0){
                    count--;
                }
            }

            int len = i - j;
            if(len>ans){
                ans = len;
            }
        }

        return ans;
    }
}
