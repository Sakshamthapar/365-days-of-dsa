// LeetCode 94 - Binary Tree Inorder Traversal
// Difficulty: Easy
// Problem: Return inorder traversal of a binary tree
// What to do: Traverse nodes in Left -> Root -> Right order
// How it works:
// - Recursively visit left subtree
// - Add current node value
// - Recursively visit right subtree
// Concept Used: Recursion, Binary Tree Traversal
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
