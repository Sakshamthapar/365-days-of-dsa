## LeetCode 1971 – Find if Path Exists in Graph

### Problem
Given an undirected graph with `n` nodes and a list of edges, determine whether a valid path exists from a given `source` node to a `destination` node.

---

### Approach
- Convert the edge list into an adjacency list
- Use Depth First Search (DFS) starting from the source node
- Track visited nodes to avoid revisiting
- If destination is reached during traversal, return `true`

---

### Algorithm
1. Build adjacency list from edges
2. Create a visited array
3. Perform DFS from source
4. Return true if destination is found, otherwise false

---

### Code (Java)
```java
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int node, int destination,
                        List<List<Integer>> graph, boolean[] visited) {
        if (node == destination) return true;
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, graph, visited)) return true;
            }
        }
        return false;
    }
}
