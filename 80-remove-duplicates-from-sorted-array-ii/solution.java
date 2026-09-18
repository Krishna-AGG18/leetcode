// 0 ms | 48.9 MB
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <=2 ) return n;
        int j = 2;
        for(int i = 2; i<n; i++){
            if(nums[i] == nums[j-2]){
                continue;
            }else{
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}