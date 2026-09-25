// 1569 ms | 56.5 MB
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // int target = 0;
        Set<List<Integer>> list = new HashSet<>(); // hashset to avoid duplicates

        for(int i = 0 ; i < n ; i++){
            int target = -nums[i];

            HashMap<Integer, Integer> map =  new HashMap<>();
            for(int j = i+1; j < n; j++){
                int need = target - nums[j];
                if(map.containsKey(need)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(need);
                    Collections.sort(temp);
                    list.add(temp);
                }
                map.put(nums[j],j);
            }
        }

        //brute force - o(n^3), gives TLE because slow 
        // for(int i = 0; i < n-2; i++){
        //     for(int j = i+1; j < n-1; j++){
        //         for(int k = j+1; k < n; k++){
        //             if(nums[i] + nums[j] + nums[k] == target){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 list.add(temp);
        //             }
        //         }
        //     }
        // }

        return new ArrayList<>(list);

    }
}