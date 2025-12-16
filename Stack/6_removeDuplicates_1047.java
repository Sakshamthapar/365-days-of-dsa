// LeetCode 1047 - Remove All Adjacent Duplicates In String
// Difficulty: Easy
// Problem: Remove all adjacent duplicate characters from a string
// What to do: Repeatedly remove pairs of adjacent equal characters
// Approach: Use a stack to track characters
// How it works:
// - Traverse the string
// - If current char equals stack top, pop
// - Otherwise push into stack
// - Build final string from stack
// Concept Used: Stack, String Traversal
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); 
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
