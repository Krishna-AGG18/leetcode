// 0 ms | 44 MB
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        //check for if array is sorted 
        if(nums[0] < nums[n-1] || n==1)
            return nums[0];

        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] > nums[n-1]){
                // i am on rihg tpart of the array and minimum value exist on the right half 
                // therefore skip and move to right 
                s = mid + 1;
            }else {
                // i am right part of the array and it might be possible its the potential soln 
                // store that soln and move left to explore if any more lesser value exist in the remaining left part
                ans = mid;
                e = mid - 1;
            }
        }

        return nums[ans];
    }
}