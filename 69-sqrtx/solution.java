// 1 ms | 42.8 MB
class Solution {
    public int mySqrt(int x) {

        int low = 0, high = x;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if ((long) mid * mid <= x) {
            // since square is less than x it can be potential soln
            // therefore store it and move right for more bigger number to get more close to x 
            // such that square is <= x..........
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}