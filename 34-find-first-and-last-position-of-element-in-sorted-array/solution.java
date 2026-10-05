// 0 ms | 46.2 MB
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findF(nums, target);
        int last = findL(nums, target);
        return new int[]{first, last};
    }

    // Function to find the first occurrence
    private int findF(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;           // Store the index
                end = mid - 1;       // Keep looking in the left half
            } else if (nums[mid] < target) {
                start = mid + 1;     // Move to right half
            } else {
                end = mid - 1;       // Move to left half
            }
        }
        return ans;
    }

    // Function to find the last occurrence
    private int findL(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;           // Store the index
                start = mid + 1;     // Keep looking in the right half
            } else if (nums[mid] < target) {
                start = mid + 1;     // Move to right half
            } else {
                end = mid - 1;       // Move to left half
            }
        }
        return ans;
    }
}
