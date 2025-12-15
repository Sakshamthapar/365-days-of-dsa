// LeetCode 160 - Intersection of Two Linked Lists
// Difficulty: Easy
// Problem: Find the node where two singly linked lists intersect
// What to do: Return the intersection node if it exists, otherwise return null
// Approach: Two pointer switching technique
// How it works:
// - Traverse both lists using two pointers
// - When a pointer reaches the end, redirect it to the other list
// - Pointers meet at the intersection node
// Concept Used: Linked List, Two Pointer Technique
// Time Complexity: O(n + m)
// Space Complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}
