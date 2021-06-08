/* Tags: Hash Table, String */
// My solution
// O(n)
// O(1)
class Solution {
    public int firstUniqChar(String s) {
        if(s == null) {
            return -1;
        }
        int[] table = new int[128];
        for(int i = 0; i < s.length(); i++) {
            table[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(table[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        if(s == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
