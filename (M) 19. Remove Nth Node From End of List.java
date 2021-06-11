/* Tags: Linked List, Two Pointers */

// My solution:
// O(n)
// O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        int length = 0;
        ListNode p = head;
        while(p != null) {
            length++;
            p = p.next;
        }
        int k = length - n;
        ListNode cur = head;
        ListNode prev = dummyNode;
        for(int i = 0; i < k; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return dummyNode.next;
    }
}

// My second solution
// O(n)
// O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode accessor = dummyNode;
        int count = n;
        while(count != 0 && accessor != null) {
            count--;
            accessor = accessor.next;
        }
        if(accessor == null) {
            return dummyNode.next;
        }
        while(accessor.next != null) {
            accessor = accessor.next;
            prev = prev.next;
        }
        if(prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
        return dummyNode.next;
    }
}

// Solution 2: One pass
// 比我写的第二个方法简洁一些
// 这里利用了the difference between two pointers
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
