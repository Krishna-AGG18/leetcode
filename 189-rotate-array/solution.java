// 7 ms | 268.7 MB
class Solution {

    public void reverse(int[] nums,int left, int right){
        while(left < right){
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        //optimised
        int n = nums.length;
        k %= n;

        //reverse entire array
        reverse(nums, 0, n-1);

        //reverse first k elements
        reverse(nums, 0,k-1);

        //reverse the remaing k 
        reverse(nums, k, n-1);

        // brute force
        // k = k % nums.length;
        // int temp[]  = new int[k];
        // int len = nums.length;
        // //store the last k elemetns
        // for(int i = 0; i < k; i++ ){
        //     temp[i] = nums[len - i - 1];
        // }

        // //shift the elements
        // for(int i = len -1; i >= k; i--){
        //     nums[i] = nums[i-k];
        // }

        // //append at first the elements of temp
        // for(int i = 0; i < k ; i++){
        //     nums[i] = temp[k-1-i];
        // }
    }
}