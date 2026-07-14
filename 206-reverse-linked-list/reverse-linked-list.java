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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }

        ListNode present = head;
        ListNode prev = null;
        ListNode nextP = head.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = nextP;
            nextP = (nextP != null) ? nextP.next : null;
        }
        return prev;
    }
}