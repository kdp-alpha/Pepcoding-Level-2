class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 1;
        int val1 = nums[0];
        int cnt2 = 0;
        int val2 = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==val1){
                cnt1++;
            }
            else if(nums[i]==val2){
                cnt2++;
            }
            else{
                if(cnt1==0){
                    val1 = nums[i];
                    cnt1 = 1;
                }
                else if(cnt2==0){
                    val2 = nums[i];
                    cnt2 = 1;
                }
                else{
                    cnt1--;
                    cnt2--;
                }
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == val1){
                count1++;
            }else if(nums[i] == val2){
                count2++;
            }
        }
        if(count1 > (n/3)){
            list.add(val1);
        }
        if(count2 > (n/3)){
            list.add(val2);
            
        }
        
        return list;
    }
}
