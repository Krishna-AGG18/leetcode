// 0 ms | 43.5 MB
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //step : 1 - Transpose
        for(int i = 0; i < n ; i++){
            for(int j = i; j < n ; j++ ){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //step : 2 - swap rows
        for(int i = 0; i < n ; i++){
            int left = 0;
            int right = n-1;
            while(left <= right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}