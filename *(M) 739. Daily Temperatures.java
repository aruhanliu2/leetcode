/* Hash Table, Stack */
// My solution
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while(!stack.isEmpty() &&
                  cur > temperatures[stack.peek()]) {
                int k = stack.pop();
                result[k] = i - k;
            }
            stack.push(i);
        }
        return result;
    }
}

// Another solution without stack
// https://leetcode.com/problems/daily-temperatures/discuss/121787/C%2B%2B-Clean-code-with-explanation%3A-O(n)-time-and-O(1)-space-(beats-99.13)
vector<int> dailyTemperatures(vector<int>& temperatures) {
    vector<int> res(temperatures.size());
    for (int i = temperatures.size() - 1; i >= 0; --i) {
        int j = i+1;
        while (j < temperatures.size() && temperatures[j] <= temperatures[i]) {
            if (res[j] > 0) j = res[j] + j;
            else j = temperatures.size();
        }
        // either j == size || temperatures[j] > temperatures[i]
        if (j < temperatures.size()) res[i] = j - i;
    }
    return res;
}
