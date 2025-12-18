// LeetCode 102 - Binary Tree Level Order Traversal
// Difficulty: Medium
// Problem: Return level-wise traversal of a binary tree
// What to do: Traverse nodes level by level from left to right
// How it works:
// - Use BFS with a queue
// - Process nodes level by level using queue size
// - Store each level separately
// Concept Used: Breadth First Search (BFS), Queue
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
