## LeetCode 3 – Longest Substring Without Repeating Characters

### Problem
Given a string `s`, find the length of the longest substring without repeating characters.

---

### Approach
This problem is solved using the **Sliding Window** technique with two pointers and a HashSet to track unique characters.

---

### Algorithm
1. Initialize two pointers `left` and `right`
2. Use a HashSet to store characters in the current window
3. Move `right` forward:
   - If character is not in set, add it and update maximum length
   - If character is already present, remove characters from left until duplicate is removed
4. Continue until the end of the string

---

### Code (Java)
```java
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
