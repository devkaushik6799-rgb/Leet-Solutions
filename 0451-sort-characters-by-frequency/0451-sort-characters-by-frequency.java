import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // 1. Use a HashMap to count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // 2. Collect the unique characters into a list to sort them
        List<Character> characters = new ArrayList<>(freqMap.keySet());

        // 3. Sort characters by their frequency in descending order
        Collections.sort(characters, (a, b) -> freqMap.get(b) - freqMap.get(a));

        // 4. Build the result string by appending each character 'n' times
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
