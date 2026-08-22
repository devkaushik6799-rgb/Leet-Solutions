class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. Hamesha chhhote array par binary search chalayenge
        // taaki search space kam rahe aur complexity O(log(min(m, n))) bane
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int pehlaSize = nums1.length;
        int doosraSize = nums2.length;

        int start = 0;
        int end = pehlaSize;

        while (start <= end) {
            // pehla cut point (nums1 me kitne elements left side lene hain)
            int pehlaCut = (start + end) / 2;

            // doosra cut point (baki ke bache hue elements nums2 se lenge)
            int doosraCut = (pehlaSize + doosraSize + 1) / 2 - pehlaCut;

            // Out of bounds se bachne ke liye Min aur Max Integer values use ki hain
            int leftKaMax1 = (pehlaCut == 0) ? Integer.MIN_VALUE : nums1[pehlaCut - 1];
            int leftKaMax2 = (doosraCut == 0) ? Integer.MIN_VALUE : nums2[doosraCut - 1];

            int rightKaMin1 = (pehlaCut == pehlaSize) ? Integer.MAX_VALUE : nums1[pehlaCut];
            int rightKaMin2 = (doosraCut == doosraSize) ? Integer.MAX_VALUE : nums2[doosraCut];

            // 2. Check karo kya sahi partition mil gaya hai
            if (leftKaMax1 <= rightKaMin2 && leftKaMax2 <= rightKaMin1) {
                // Agar total length ODD hai, toh Left Part ka maximum hi answer hoga
                if ((pehlaSize + doosraSize) % 2 == 1) {
                    return Math.max(leftKaMax1, leftKaMax2);
                } 
                // Agar total length EVEN hai, toh Left Max aur Right Min ka average nikalenge
                else {
                    return (Math.max(leftKaMax1, leftKaMax2) + Math.min(rightKaMin1, rightKaMin2)) / 2.0;
                }
            } 
            // 3. Agar nums1 ka left element bada ho gaya, toh pehla cut chhota karne ke liye left me shift karo
            else if (leftKaMax1 > rightKaMin2) {
                end = pehlaCut - 1;
            } 
            // 4. Agar nums2 ka left element bada hai, toh pehla cut bada karne ke liye right me shift karo
            else {
                start = pehlaCut + 1;
            }
        }

        return 0.0;
    }
}