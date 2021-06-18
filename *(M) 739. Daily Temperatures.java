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
