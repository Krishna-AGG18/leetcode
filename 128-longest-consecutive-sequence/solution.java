// 36 ms | 95.8 MB
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int ans = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        // for(int num : nums){ ----> iterate over the hashset not the array
        for(int num : set){
            if(!set.contains(num-1)) {

            int count = 1;
            int val = num;

            while(set.contains(val + 1)){
                count++;
                val++;
            }
            ans = Math.max(ans,count);
            }
        }

    return ans;
}}