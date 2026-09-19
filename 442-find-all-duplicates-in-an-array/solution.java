// 6 ms | 57.5 MB
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            int value = Math.abs(nums[i]);
            int pos = value - 1;

            if(nums[pos] > 0){
                nums[pos] = -nums[pos];
            }else{
                ans.add(pos+1);
            }
        }
        
        return ans;
    }
}