// 0 ms | 52.3 MB
class Solution {
    public int singleNonDuplicate(int[] nums) {

        // My correct pairs are: [0,1], [2,3], [4,5]...
        // If they are right in terms of indexes, the pair starts at an even index.
        // Order breaks as soon as the faulty single element is encountered.
        // So instead of starting at an even index, pairs start at an odd index.
        // Identify the half where things are faulty, then move back/forward accordingly.

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int s = 0;
        int e = n - 1;

        while (s <= e) {

            int m = s + (e - s) / 2;

            // Single element case:
            // Assume s, e and m are all pointing to index 5.
            // That means only one element is left, so that's our answer.
            if (s == e)
                return nums[s];

            int curr = nums[m];

            // Check if current element matches the previous element.
            // Boundary check is necessary to avoid ArrayIndexOutOfBoundsException.
            if (m > 0 && curr == nums[m - 1]) {

                // Current index is odd and matches previous (even) index.
                // Pair is correctly aligned till here, so move right.
                if ((m & 1) == 1)
                    s = m + 1;

                // Current index is even and matches previous (odd) index.
                // Pair alignment is disturbed, so single element is in left half.
                else
                    e = m - 1;
            }

            // Check if current element matches the next element.
            else if (m + 1 < n && curr == nums[m + 1]) {

                // Current index is even and matches next (odd) index.
                // Pair is correctly aligned till here, so move right.
                if ((m & 1) == 0)
                    s = m + 1;

                // Current index is odd and matches next (even) index.
                // Pair alignment is disturbed, so single element is in left half.
                else
                    e = m - 1;
            }

            // Current element doesn't match either previous or next.
            // Hence, this is the single non-duplicate element.
            else {
                return curr;
            }
        }

        return -1;
    }
}