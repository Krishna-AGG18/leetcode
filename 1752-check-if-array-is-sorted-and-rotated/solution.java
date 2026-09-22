// 0 ms | 43 MB
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        //just count number of rotations and if ratation count is greater than 1 its false 
        //Sorted rotated array mein circularly numbers decrease hone ki maximum 1 jagah ho sakti hai.
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}