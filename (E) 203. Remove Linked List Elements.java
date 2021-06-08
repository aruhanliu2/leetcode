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
