/* Tags: Array, Hash Table */

// Approach 1: Brute Force
// Time: O(n^2)
// Space: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// Approach 2: Two-pass Hash Table
// Time: O(n)
// Space: O(n)
// We reduce the look up time from O(n) to O(1) by trading space for speed.
// A hash table is built exactly for this purpose, it supports fast look up in near constant time.
// I say "near" because if a collision occurred, a look up could degenerate to O(n) time.
// But look up in hash table should be amortized O(1) time as long as the hash function was chosen carefully.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// Approach 3: One-pass Hash Table
// Time: O(n)
// Space: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/* 首先要学会写Brute force，分析复杂度，然后再考虑优化
 * 这道题没有办法先sort array，再使用夹逼法，因为要求你返回数字的index，位置需要固定，所以Hash Table是最好的solution.
 */
