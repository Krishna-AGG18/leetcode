// 11 ms | 50 MB
class Solution {
    
    static boolean isvalid(int[] arr, int days, int maxweight){
        
        int ship =1;
        int w =0;
        
        for(int num : arr){
            if((w+num ) <= maxweight){
                w+= num;
            }else{
                ship++;
                w= num;
            }
        }
        
        return ship <= days;
    }
    
    
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int s =0;
        int e =0;
        int ans =-1;
        for(int num : weights){
            s = Math.max(s,num);
            e += num;
        }
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(isvalid(weights,days,mid)){
                ans = mid;
                e= mid -1;
            }else{
                s=mid+1;
            }
        }
        
        return ans;
    }
}