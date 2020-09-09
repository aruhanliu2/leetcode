class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int result = (int) (helper(nums1, nums2) + helper(nums2, nums1));
        return result;
    }
    
    public long helper(int[] nums1, int[] nums2)
    {
        long result = 0;
        for (int i = 0; i < nums1.length; i++)
        {
            Map<Long, Long> map = new HashMap<>();
            long pivot = nums1[i] * nums1[i];
            for (long v : nums2)
            {
                if (pivot % v == 0)
                {
                    result += map.getOrDefault(pivot / v, 0l);
                }
                map.put(v, map.getOrDefault(v, 0l) + 1);
            }
        }
        return result;
    }
}
