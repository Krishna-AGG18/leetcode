// 0 ms | 42.9 MB
class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int low = 0;
        int ans = -1;
        for(int num : nums){
            low = Math.max(low,num);
            sum+=num;
        }

        int s = low;
        int e = sum;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(isValid(nums,k,mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid+1;
            }
        }

        return ans;
    }

    static boolean isValid(int nums[], int k, int max){
        int split  = 1;
        int sum = 0;

        for(int num : nums){
            if((sum + num) <= max){
                sum += num;
            }else{
                split++;
                sum = num;
            }
        }

        return split <= k;
    }
}