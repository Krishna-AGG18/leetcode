// 20 ms | 49.3 MB
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int majorityElement = nums[0];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (map.get(num) > maxCount) {
                maxCount = map.get(num);
                majorityElement = num;
            }
        }

        return majorityElement;
    }
}
