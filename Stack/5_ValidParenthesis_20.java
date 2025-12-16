// LeetCode 20 - Valid Parentheses
// Difficulty: Easy
// Problem: Check if the input string of brackets is valid
// What to do: Ensure every opening bracket has a matching closing bracket
//             of the same type and in the correct order
// Approach: Use a stack to track opening brackets
// How it works:
// - Push opening brackets onto the stack
// - On closing bracket, check if it matches the top of the stack
// - If mismatch or stack is empty, return false
// - At the end, stack must be empty
// Concept Used: Stack, String Traversal
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())return false;
                char top =stack.pop();
                if( 
                    (ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')
                ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
