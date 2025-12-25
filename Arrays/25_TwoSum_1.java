# LeetCode 1 – Two Sum

## 🧩 Problem
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

- Each input has **exactly one solution**
- You may not use the same element twice
- The answer can be returned in any order

---

## 💡 Approach
To solve this efficiently, we use a **HashMap**.

- While iterating through the array, store each number along with its index.
- For every number, calculate its complement (`target - current number`).
- If the complement already exists in the map, we have found the solution.

This avoids the brute-force `O(n²)` approach.

---

## 🛠️ Algorithm
1. Create a HashMap to store numbers and their indices
2. Traverse the array
3. For each element:
   - Calculate the complement
   - Check if it exists in the map
4. If found, return both indices
5. Otherwise, store the current number with its index

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---
---

## 💻 Java Solution
```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
