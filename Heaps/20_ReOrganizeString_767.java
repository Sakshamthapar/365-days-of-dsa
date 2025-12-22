## LeetCode 767 – Reorganize String

### Problem
Given a string `s`, rearrange the characters so that no two adjacent characters are the same.  
Return any valid rearrangement or an empty string if not possible.

---

### Approach
To prevent adjacent duplicates, we always place the character with the highest remaining frequency next.

A **Max Heap (PriorityQueue)** helps efficiently retrieve the most frequent character at each step.

---

### Algorithm
1. Count frequency of each character
2. Push characters into a max heap based on frequency
3. Repeatedly:
   - Pick the most frequent character
   - Append it to result
   - Reinsert the previous character if it still has remaining count
4. Validate the result length

---

### Code (Java)
```java
import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.append((char) (curr[0] + 'a'));
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.add(prev);
            }

            prev = curr;
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}
