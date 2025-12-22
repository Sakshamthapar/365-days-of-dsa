## LeetCode 162 – Find Peak Element

### Problem
Given an array `nums`, find a peak element and return its index.  
A peak element is strictly greater than its neighbors.

---

### Approach
Using **Binary Search**, we compare mid elements with their next neighbor to decide the direction where a peak exists.

---

### Algorithm
1. Initialize two pointers `low` and `high`
2. While `low < high`:
   - Compute `mid`
   - If `nums[mid] > nums[mid + 1]`, move left
   - Else move right
3. Return `low` as the peak index

---

### Code (Java)
```java
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
