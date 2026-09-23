class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int MaxInd = 0;
        for(int i=0; i<n; i++){
            if(i > MaxInd) return false;
            MaxInd = Math.max(MaxInd, i + nums[i]);
        }
        return true;
    }
}