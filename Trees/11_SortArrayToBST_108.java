// LeetCode 108 - Convert Sorted Array to Binary Search Tree
// Difficulty: Easy
// Problem: Convert a sorted array into a height-balanced BST
// What to do: Build a BST such that height difference is minimal
// How it works:
// - Choose middle element as root
// - Recursively build left and right subtrees
// Concept Used: Recursion, Binary Search Tree
// Time Complexity: O(n)
// Space Complexity: O(log n) (recursion stack)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
