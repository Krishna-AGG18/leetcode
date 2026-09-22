// 3 ms | 175.8 MB
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int i = 0; 
        int j = 1;

        for(int num : nums){
            if(num < 0){
                ans[j] = num;
                j = j+2;
            }else{
                ans[i] = num;
                i = i + 2;
            }
        }

        return ans;
    }
}