import java.util.*;

class Solution {

    void func(int ind, int[] arr,
              ArrayList<Integer> current,
              List<List<Integer>> result) {

        if (ind == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(arr[ind]);
        func(ind + 1, arr, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude the current element
        func(ind + 1, arr, current, result);
    }

    public List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        func(0, arr, current, result);

        return result;
    }
}