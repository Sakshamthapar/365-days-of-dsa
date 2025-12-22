###LeetCode 743 – Network Delay Time

###Approach
This is a single-source shortest path problem with positive edge weights.
Use Dijkstra’s Algorithm to find the shortest time from the source node to all other nodes.
Represent the graph using an adjacency list.
Use a priority queue (min-heap) to always process the node with the smallest current distance.
---

###Algorithm
1. Create an adjacency list from the times array
2. Initialize a distance array with infinity for all nodes
3. Set the distance of the source node k to 0
4. Use a priority queue to process nodes by minimum distance
5. Relax edges and update distances if a shorter path is found
6. After processing all nodes, return the maximum distance
7. If any node is unreachable, return -1

---

###Code (Java)

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            graph[t[0]].add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[next] > time + wt) {
                    dist[next] = time + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

