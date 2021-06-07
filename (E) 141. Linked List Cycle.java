/* Tags: Linked List, Two Pointers */

// My solution
// O(n)
// O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            // 易错点1：忘记检查fast.next == null，这是链表最容易出错的地方，不检查null pointer
            if(slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

// Solution 1: fast slow pointer
/* Time: O(N + K) = O(n)
 - No cycle: O(n)
 - Has cycle:
    - acyclic part: O(N)
    - cyclic part: Maximum distance between two pointers / speed difference = O(K) / 1 = O(K)
    - O(N) + O(K) = O(n)
*/
// Space: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 这里写的比我简洁，其实不需要检查head.next == null，因为后面的for loop里会检查
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 这里不需要检查slow == null，因为fast总在slow的前面，如果fast不是null，那slow也不会是null
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
