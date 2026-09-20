// 2 ms | 47.1 MB
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curmax = 1;
        int curmin = 1;

        for(int num : nums){
            int prod = curmax*num;
            curmax = Math.max(num, Math.max(prod, curmin*num));
            curmin = Math.min(num, Math.min(prod, curmin*num));

            res = Math.max(res,curmax);
        }

        return res;
    }
}