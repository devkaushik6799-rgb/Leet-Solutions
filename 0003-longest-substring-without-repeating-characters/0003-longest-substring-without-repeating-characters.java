class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int right=0; right<s.length(); right++){
            char current = s.charAt(right);
            if(
                lastSeen.containsKey(current)&&
                lastSeen.get(current)>=left
            ){
                left = lastSeen.get(current) + 1;
            }
            lastSeen.put(current, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}