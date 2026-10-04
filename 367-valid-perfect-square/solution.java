// 0 ms | 42.1 MB
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int h = num;

        while(l <= h){
            int mid = l + (h-l)/2;

            if((long) mid*mid == num){
                return true;
            }else if ((long) mid*mid < num){
                l = mid+1;
            }else{
                h = mid - 1;
            }
        }

        return false;
    }
}