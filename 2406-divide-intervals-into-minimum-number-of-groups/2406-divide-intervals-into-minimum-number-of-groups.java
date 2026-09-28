import java.util.Arrays;

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = intervals[i][0];
            dep[i] = intervals[i][1];
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int cnt = 0;
        int maxCnt = 0;

        while (i < n) {
            if (arr[i] <= dep[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt;
    }
}