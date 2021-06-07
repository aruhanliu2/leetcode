/* Tags: Linked List */

// My solution
// O(n)
// O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode temp = cur;
            // 易错点1：忘记检查temp != null
            while(temp != null && temp.val == cur.val) {
                temp = temp.next;
            }
            cur.next = temp;
            // 易错点2：忘记increment the pointer
            cur = cur.next;
        }
        return head;
    }
}

// Solution 1: Straight forward
// O(n)
// O(1)
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
