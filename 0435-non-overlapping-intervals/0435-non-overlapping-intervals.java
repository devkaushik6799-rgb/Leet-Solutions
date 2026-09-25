class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
                Arrays.sort(intervals, (first, second) -> Integer.compare(first[1], second[1]));
                int cnt = 1;
                int n = intervals.length;
                int lastEndingTime = intervals[0][1];
                for(int i=0; i<=n-1; i++){
                    if(intervals[i][0]>=lastEndingTime){
                        cnt = cnt+1;
                        lastEndingTime = intervals[i][1];
                    }
                }
                return n-cnt;
    }
}