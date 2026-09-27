// 1 ms | 45.7 MB
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        //reverse the row
        for(int i = 0; i  <n ; i ++){
            int left = 0;
            int right = n-1;

            while(left <= right){
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }
        }

        int ans[][] = new int[n][n];

        for(int i = 0 ; i <n ; i++){
            for(int j = 0; j <n ;j++){
                ans[i][j] = (image[i][j] == 0) ? 1 : 0;
            }
        }

        return ans;
    }
}