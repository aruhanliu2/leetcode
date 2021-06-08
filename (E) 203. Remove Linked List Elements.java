/* Tags: Linked List */
// My solution
// O(n)
// O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
/*
    Sentinel nodes are widely used in trees and linked lists as pseudo-heads, pseudo-tails, markers of level end, etc.
    They are purely functional, and usually does not hold any data.
    Their main purpose is to standardize the situation,
    for example, make linked list to be never empty and never headless and hence simplify insert and delete.
    Here are two standard examples:
    - LRU Cache, sentinel nodes are used as pseudo-head and pseudo-tail.
    - Tree Level Order Traversal, sentinel nodes are used to mark level end.
*/
