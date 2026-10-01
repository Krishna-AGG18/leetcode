// 0 ms | 43 MB
class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int srow = 0;
        int erow = n-1;
        int scol = 0; 
        int ecol = n-1;
        int val = 1;

        while(srow <= erow && scol <= ecol){
            //r to l - scol t ecol
            for(int i = scol; i <=ecol; i++){
                ans[srow][i] = val;
                val++;
            }
            srow++;

            //t to b - srow to erow
            for(int i = srow; i<= erow; i++){
                ans[i][ecol] = val;
                val++;
            }
            ecol--;

            //check for single row ?? then l to r
            if(srow <= erow){
                for(int i = ecol ; i >= scol; i--){
                    ans[erow][i] = val;
                    val++;
                }
            }
            erow--;
            //check for signle column -  b to t from erow to srow
            if(scol <= ecol){
                for(int i = erow; i >= srow; i-- ){
                    ans[i][scol] = val;
                    val++;
                }
            }
            scol++;
        }

        return ans;

    }
}