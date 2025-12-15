// LeetCode 19 - Remove Nth Node From End of List
// Difficulty: Medium
// Problem: Remove the nth node from the end of a singly linked list
// What to do: Delete the nth node counting from the end and return the updated head
// Approach: Use two pointers with a dummy node
// How it works:
// - Move fast pointer n steps ahead
// - Move both fast and slow until fast reaches the end
// - Remove the node after slow
// Concept Used: Linked List, Two Pointer Technique, Dummy Node
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=0 ; i<n;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
