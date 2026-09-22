// 1 ms | 46.2 MB
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int num : nums){
            xor ^= num;
        }

        return xor;
    }
}