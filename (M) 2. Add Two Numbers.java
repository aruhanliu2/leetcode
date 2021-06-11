/* Tags: Linked List, Math, Recursion */
// My solution
// O(max(m,n)
// O(max(m,n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit = 0;
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;
        while(l1 != null || l2 != null) {
            int sum = 0;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            sum += digit;
            p.next = new ListNode(sum % 10);
            digit = sum / 10;
            p = p.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(digit == 1) {
            p.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
