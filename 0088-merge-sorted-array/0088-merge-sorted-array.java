class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;         // pointer for the end of valid elements in nums1
        int p2 = n - 1;         // pointer for the end of nums2
        int p = m + n - 1;      // pointer for the end of nums1 array

        while (p2 >= 0) {
            // If nums1 still has elements and its current element is larger
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Otherwise take from nums2
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
}