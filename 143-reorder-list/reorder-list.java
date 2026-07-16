/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode second = getMid(head);
        ListNode secondList = reverseList(second.next);
        second.next = null;                     // Break the list

        while (secondList != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = secondList.next;

            head.next = secondList;
            secondList.next = temp1;

            head = temp1;
            secondList = temp2;
        }
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode nextD = (present != null) ? present.next : null;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = nextD;
            if (nextD != null) {
                nextD = nextD.next;
            }
        }
        return prev;
    }
}