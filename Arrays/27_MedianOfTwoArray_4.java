# LeetCode 4 – Median of Two Sorted Arrays

## 🧩 Problem
Given two sorted arrays `nums1` and `nums2` of sizes `m` and `n`, return the **median** of the two sorted arrays.

The overall time complexity should be **O(log (m+n))**.

---

## 💡 Approach
This problem is solved using **Binary Search on Partition**.

Key idea:
- Perform binary search on the **smaller array**
- Partition both arrays such that:
  - Left half contains `(m + n + 1) / 2` elements
  - All elements on the left ≤ all elements on the right
- Median depends on whether total length is even or odd

---

## 🛠️ Algorithm
1. Ensure `nums1` is the smaller array
2. Apply binary search on `nums1`
3. Calculate partitions `partitionX` and `partitionY`
4. Compare boundary elements to validate partition
5. Compute median based on total length

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(log(min(m, n)))`
- **Space Complexity:** `O(1)`

---

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) +
                            Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } 
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } 
            else {
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}
