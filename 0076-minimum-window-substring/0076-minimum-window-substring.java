
class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (m > n) return "";

        int[] hash = new int[128];

        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int cnt = 0;

        int minLen = Integer.MAX_VALUE;
        int startInd = -1;

        while (r < n) {

            char ch = s.charAt(r);

            if (hash[ch] > 0) {
                cnt++;
            }

            hash[ch]--;

            while (cnt == m) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startInd = l;
                }

                char left = s.charAt(l);

                hash[left]++;

                if (hash[left] > 0) {
                    cnt--;
                }

                l++;
            }

            r++;
        }

        return startInd == -1 ? "" :
            s.substring(startInd, startInd + minLen);
    }
}
