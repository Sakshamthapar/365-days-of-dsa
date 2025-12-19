## LeetCode 997 – Find the Town Judge

### Problem
In a town of `n` people, a town judge:
- Trusts nobody
- Is trusted by everyone else

Given trust relationships, find the judge or return `-1`.

---

### Approach
- Use an array to track trust score for each person
- Decrease score when a person trusts someone
- Increase score when a person is trusted
- The judge will have a trust score of `n - 1`

---

### Algorithm
1. Initialize trustScore array of size `n+1`
2. For each trust pair `[a, b]`:
   - Decrease trustScore[a]
   - Increase trustScore[b]
3. Scan for a person with trustScore = `n - 1`

---

### Code (Java)
```java
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1];

        for (int[] t : trust) {
            trustScore[t[0]]--;
            trustScore[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) return i;
        }
        return -1;
    }
  }
