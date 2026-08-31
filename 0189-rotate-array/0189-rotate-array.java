class Solution {
    public void rotate(int[] nums, int k) {
     int n = nums.length;
     if(n==0 || k==0)return;
     k = k%n;
     reverseArray(nums, 0, n-1);
     reverseArray(nums, 0, k-1);
     reverseArray(nums, k, n-1);
}
void reverseArray(int[] nums, int start, int end){
    while(start<end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
 }
}
