// 7 ms | 47.7 MB
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // isko ese samjho ki max h hours ha and minimum kitne me hame saare kele kha sakte hai 
        int n = piles.length;
        int s = 1;
        int e = 0;

        for(int pile : piles){
            e = Math.max(e,pile);
        }


        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;

            if(calcTotalHours(piles, mid) <= h){
                ans = mid;
                e = mid -1;
            }else{
                s = mid +1;
            }
        }

        return ans;
    }

    static long calcTotalHours(int[] piles, int max){

        long total = 0;
        for(int pile : piles){
            total += (pile + (long) max -1)/max;
        }

        return total;

    }
}