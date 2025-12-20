## LeetCode 387 – First Unique Character in a String

### Problem
Given a string `s`, find the first non-repeating character and return its index.  
If it does not exist, return `-1`.

---

### Approach
- Since the string contains only lowercase letters, use a frequency array of size 26.
- First pass: count frequency of each character.
- Second pass: find the first character with frequency `1`.

---

### Algorithm
1. Create an integer array of size 26
2. Count frequency of each character
3. Traverse string again to find first unique character
4. Return its index or `-1`

---

### Code (Java)
```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
