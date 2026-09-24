// 0 ms | 43 MB
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int s_row = 0;
        int s_col = 0;
        int e_col = n - 1;
        int e_row = m - 1;

        while (s_row <= e_row && s_col <= e_col) {
            //row wise L to R - print starting row from s_col to e_col
            for (int col = s_col; col <= e_col; col++) {
                result.add(matrix[s_row][col]);
            }
            s_row++;
            //col wise T to B - print ending col from start row to end row
            for (int row = s_row; row <= e_row; row++) {
                result.add(matrix[row][e_col]);
            }
            e_col--;
            //row wise R to L - print last row , from end col to start col
            //valid ending row -> s_row <= e_row
            if (s_row <= e_row) {
                for (int col = e_col; col >= s_col; col--) {
                    result.add(matrix[e_row][col]);
                }
                e_row--;
            }
            // col wise B to T - print start col from end row to start row
            //valid starting col -> s_col <= e_col
            if (s_col <= e_col) {
                for (int row = e_row; row >= s_row; row--) {
                    result.add(matrix[row][s_col]);
                }
                s_col++;
            }
        }

        return result;
    }
}