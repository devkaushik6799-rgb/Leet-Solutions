class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        // Step 1: Count break points
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
            }
        }
        
        // Step 2: Handle the three cases
        if (count == 0) return true;
        if (count == 1 && nums[0] >= nums[n-1]) return true;
        return false;
    }
}