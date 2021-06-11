/* Tags: Hash Table, Two Pointers, String, Sliding Window */

// My solution
// O(n) (Even in worst case when all the chars are the same, the total time is O(2n) which is O(n))
// Space complexity: O(n) in worst case scenario when all the chars are distinct.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            if(set.contains(c)) {
                while(i < s.length() && set.contains(c)) {
                    set.remove(s.charAt(i++));
                }
            }
            maxLength = Math.max(maxLength,j - i + 1);
            set.add(c);
            j++;
        }
        return maxLength;
    }
}

// Solution 1: Brute force
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }
}

// Solution 2: Sliding Window
// Time complexity : O(2n) = O(n). In the worst case each character will be visited twice.
// Space complexity : O(min(m, n)). Same as the previous approach. We need O(k) space for the sliding window, where k is the size of the Set.
// The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}

// Solution 3: Sliding Window Optimized
// Time complexity : O(n). Index jj will iterate nn times.
// Space complexity O(min(m,n)).
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}

// Solution 4: ASCII code
// The previous implements all have no assumption on the charset of the string s.
// If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
/* Commonly used tables are:
int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII
*/
// Time complexity : O(n).
// Space complexity (Table): O(m). m is the size of the charset.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
