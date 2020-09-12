// Array
// My solution
// O(n), O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int i = 0, j = 0;
        while (j < nums.length)
        {
            if (nums[j] == 0)
            {
                j++;
            }
            else
            {
                i = j;
                while (j < nums.length && nums[j] != 0)
                {
                    j++;
                }
                result = Math.max(result, j - i);
            }
        }
        return result;
    }
}

// Approach: One pass
// O(n), O(1)
// 这个解优秀的地方是用count代替了i指针，不需要loop中还有loop，简化了代码
class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int maxCount = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == 1) {
        // Increment the count of 1's by one.
        count += 1;
      } else {
        // Find the maximum till now.
        maxCount = Math.max(maxCount, count);
        // Reset count of 1.
        count = 0;
      }
    }
    return Math.max(maxCount, count);
  }
}
