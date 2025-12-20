## LeetCode 347 – Top K Frequent Elements

### Problem
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

---

### Approach (Bucket Sort)
- Count frequency using HashMap
- Create buckets where index represents frequency
- Place numbers into buckets
- Traverse buckets from highest frequency to lowest

---

### Algorithm
1. Count frequency of each number
2. Create a bucket array of size `n + 1`
3. Store numbers based on their frequency
4. Traverse buckets from right to left
5. Collect first `k` elements

---

### Code (Java)
```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null)
                result.addAll(bucket[i]);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = result.get(i);

        return ans;
    }
}
