// Hash Table, Two Pointers, String, Sliding Window
// Approach 1

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        while (j < s.length())
        {
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
            else
            {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }
}
