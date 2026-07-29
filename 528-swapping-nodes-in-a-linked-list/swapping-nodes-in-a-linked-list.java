class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode slow1 = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            slow = slow.next;
        }

        // Start fast k-1 nodes ahead, not k
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        // Move slow1, not assign it
        while (fast.next != null) {
            slow1 = slow1.next;
            fast = fast.next;
        }

        int temp = slow.val;
        slow.val = slow1.val;
        slow1.val = temp;

        return head;
    }
}