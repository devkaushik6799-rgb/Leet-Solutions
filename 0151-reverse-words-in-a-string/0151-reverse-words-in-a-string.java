class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        
        while(i >= 0) {
            // Skip trailing spaces first (at current position while moving left)
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // Check bounds before continuing
            if(i < 0) break;
            
            // Mark end position of current word
            int end = i;
            
            // Find start position of current word
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            
            // Extract word and add to result
            String word = s.substring(i + 1, end + 1);
            
            if(result.length() > 0) {
                result.append(' ');
            }
            result.append(word);
        }
        
        return result.toString();
    }
}