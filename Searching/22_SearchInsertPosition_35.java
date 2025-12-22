## LeetCode 35 – Search Insert Position

### Problem
Given a sorted array of distinct integers and a target value, return the index if the target is found.  
If not, return the index where it would be inserted in order.

---

### Approach
Since the array is sorted and an `O(log n)` solution is required, we use **Binary Search**.

---

### Algorithm
1. Initialize `low = 0` and `high = n - 1`
2. While `low <= high`:
   - Calculate `mid`
   - If `nums[mid] == target`, return `mid`
   - If `nums[mid] < target`, move `low` right
   - Else move `high` left
3. Return `low` as the insertion index

---

### Code (Java)
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
