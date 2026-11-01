// 9 ms | 50.4 MB
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s = 1;
        int e = 0;
        int ans = 0;
        for(int num : nums){
            e = Math.max(num,e);
        }

        while(s <= e){
            int mid = s + (e - s)/2;

            if(predicate(nums, mid) <= threshold){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return ans;
    }

    static long predicate(int[] nums, int max){
        long total = 0;
        for(int num : nums){
            total += (num + (long) max - 1 )/max;
        }
        return total;
    }
}