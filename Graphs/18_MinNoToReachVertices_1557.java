## LeetCode 1557 – Minimum Number of Vertices to Reach All Nodes

### Problem
You are given a directed acyclic graph with `n` vertices labeled from `0` to `n-1` and a list of directed edges.  
Return the smallest set of vertices from which all nodes in the graph are reachable.  
It is guaranteed that a unique solution exists.

---

### Approach
- Any node with an incoming edge can be reached from another node.
- Nodes with **no incoming edges (indegree = 0)** cannot be reached from anywhere else.
- Therefore, all nodes with indegree `0` must be included in the answer.

---

### Algorithm
1. Create an indegree array of size `n`
2. Traverse edges and increase indegree of destination nodes
3. Collect all nodes whose indegree is `0`
4. Return the result list

---

### Code (Java)
```java
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];

        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
