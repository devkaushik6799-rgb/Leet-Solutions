class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int index = -1;
        
        // Step 1: Find first decreasing element from right
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        
        // Step 2: If no such element, array is descending - reverse entire array
        if(index == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // Step 3: Find smallest element > nums[index] from right
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
        
        // Step 4: Reverse the suffix after pivot position
        reverse(nums, index + 1, nums.length - 1);
    }
}