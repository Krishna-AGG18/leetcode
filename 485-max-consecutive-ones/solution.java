// 2 ms | 52.5 MB
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int prevmax = 0;
        for(int num : nums){
            if(num == 0){
            prevmax = Math.max(prevmax,max);
            max = 0;
            } 
            else max++;
        }

        return Math.max(prevmax,max);
    }
}