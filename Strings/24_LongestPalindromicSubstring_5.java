## LeetCode 5 – Longest Palindromic Substring

### Problem
Given a string `s`, return the longest palindromic substring in `s`.

---

### Approach
This problem is solved using the **Expand Around Center** technique.  
Each character (and pair of characters) is treated as a possible center of a palindrome, and expansion is performed outward.

---

### Algorithm
1. Initialize `start` and `end` to track the longest palindrome
2. For each index `i`:
   - Expand around `(i, i)` for odd-length palindrome
   - Expand around `(i, i+1)` for even-length palindrome
3. Update the longest palindrome range if a longer one is found
4. Return the substring from `start` to `end`

---

### Code (Java)
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
