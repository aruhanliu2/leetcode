/* String, Stack, Recursion */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                stack.push(c);
            } else if(c == ']') {
                StringBuilder string = new StringBuilder();
                int number = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                    string.append(stack.pop());
                }
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number += (stack.pop() - '0') * base; //注意如何将字符转化为数字
                    base *= 10;
                }
                for(int m = 0; m < number; m++) {
                    for(int j = string.length() - 1; j >= 0; j--) {
                        stack.push(string.charAt(j));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
// https://leetcode.com/problems/decode-string/solution/
