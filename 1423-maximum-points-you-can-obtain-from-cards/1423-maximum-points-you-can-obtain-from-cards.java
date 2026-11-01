class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        for(int i=0; i<=k-1; i++) lSum = lSum+cardPoints[i];{
            int rightInd = n-1;
            maxSum = lSum;
            for(int i = k-1; i>=0; i--){
                lSum = lSum-cardPoints[i];
                rSum = rSum+cardPoints[rightInd];
                rightInd = rightInd-1;
                maxSum = Math.max(maxSum, lSum+rSum);
            }
        }
        return maxSum;
    }
}