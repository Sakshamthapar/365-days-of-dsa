## LeetCode 1046 – Last Stone Weight

### Problem
You are given an array of stones where each stone has a weight.  
On each turn, pick the two heaviest stones and smash them together.

- If the stones are equal, both are destroyed.
- If they are different, the smaller is destroyed and the larger becomes the difference.

Return the weight of the last remaining stone or `0` if none remain.

---

### Approach
Since we always need the two heaviest stones, we use a **Max Heap**.

Java’s `PriorityQueue` with reverse order allows efficient retrieval of the largest elements.

---

### Algorithm
1. Insert all stones into a max heap
2. While heap size > 1:
   - Remove two largest stones
   - If unequal, insert their difference
3. Return remaining stone or `0`

---

### Code (Java)
```java
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (y != x) {
                maxHeap.add(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
