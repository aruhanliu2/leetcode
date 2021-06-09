/* Tags: LinkedList */

// My solution
// O(n)
// O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) {
            return slow;
        } else
        {
            return slow.next;
        }
    }
}

// Solution 1: Output to Array
// O(n)
// O(n)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}

// Solution 2: Fast and Slow Pointer
//这里他做的更好的地方是，开始时让slow和fast都等于head，这样slow最终刚好在中间或中间的下一个
// O(n)
// O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
