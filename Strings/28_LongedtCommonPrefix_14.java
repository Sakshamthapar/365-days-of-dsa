# LeetCode 14 – Longest Common Prefix

## 🧩 Problem
Write a function to find the **longest common prefix string** amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

## 💡 Approach
We use **horizontal scanning**:

- Take the **first string** as the initial prefix
- Compare it with each next string
- Reduce the prefix until it matches the start of the current string
- If prefix becomes empty → return `""`

This approach is simple and efficient for the given constraints.

---

## 🛠️ Algorithm
1. If the array is empty, return `""`
2. Initialize prefix as `strs[0]`
3. Loop through remaining strings:
   - While the current string does not start with prefix:
     - Shorten the prefix by removing last character
4. Return the final prefix

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(n * m)`
  - `n` = number of strings
  - `m` = length of the shortest string
- **Space Complexity:** `O(1)`

---

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
  }
