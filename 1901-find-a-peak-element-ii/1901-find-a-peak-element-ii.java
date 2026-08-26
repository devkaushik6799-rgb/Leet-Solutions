class Solution {
    public int maxElement(int[][] arr, int col){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(arr[i][col] > max){
                max = arr[i][col];
                index = i;
            }
        }
        return index;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        
        // ✅ Fix 1: Variables scoped OUTSIDE the loop
        int row = 0, col = 0;
        
        while(low <= high){
            int mid = (low + high) / 2;
            row = maxElement(mat, mid);
            
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : Integer.MIN_VALUE;
            
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row, mid};
            } else if(mat[row][mid] < right){
                // ✅ Fix 2: Search RIGHT when neighbor is bigger
                low = mid + 1;
            } else {
                // Search LEFT
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}