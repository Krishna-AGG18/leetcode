// 0 ms | 80.3 MB
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;

            //if mid >= mid +1 --> potential soln, store and check for bigger value in right portion
            if(arr[mid] >= arr[mid+1]){
                ans = mid;
                e =  mid -1;
            }
            // if mid < mid +1 , i am on inc part of the array i am not interested here move right for bigger values
            else {
                s = mid+1;
            }
        }

        return ans;
    }
}