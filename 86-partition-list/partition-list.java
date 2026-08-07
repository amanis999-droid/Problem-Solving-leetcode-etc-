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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode temp1 = head;

        ListNode dummy = new ListNode(0);
        ListNode dummyiter1 = dummy;
        ListNode dummy1 = new ListNode(0);
        ListNode dummyiter2 = dummy1;


        while(temp != null){
            if(temp.val < x){
                ListNode newNode = new ListNode(temp.val);
                dummyiter1.next = newNode;
                dummyiter1 = dummyiter1.next;
            }
            temp = temp.next;
        }

        while(temp1 != null){
            if(temp1.val >= x){
                ListNode newNode = new ListNode(temp1.val);
                dummyiter2.next = newNode;
                dummyiter2 = dummyiter2.next;
            }
            temp1 = temp1.next;
        }

        dummyiter1.next = dummy1.next;
        return dummy.next;

    }
}