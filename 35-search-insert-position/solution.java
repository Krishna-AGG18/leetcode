// 0 ms | 42.9 MB
class Solution {
    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        int found = -1;
        while (end >= start) {
            int mid = (end + start) / 2;
            if(nums[mid] == target){
            found = mid;
            return mid;
            }
            else if (target > nums[mid])
            start = mid + 1;
            else 
            end = mid -1;
        }

        if(found == -1){
            
            return start;
        }else{
            return found;
        }
    }

    
}