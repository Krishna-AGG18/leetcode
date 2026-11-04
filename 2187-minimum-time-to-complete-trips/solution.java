// 51 ms | 90.7 MB
class Solution {

    static boolean isvalid(int[] time, int totalTrips, long minT) {
        long trips = 0;

        for (int t : time) {
            trips += minT / t;

            if (trips >= totalTrips) {
                return true;
            }
        }

        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {

        long s = 1;
        int minTime = Integer.MAX_VALUE;

        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long e = (long) minTime * totalTrips;
        long ans = e;

        while (s <= e) {
            long mid = s + (e - s) / 2;

            if (isvalid(time, totalTrips, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}