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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1 || head == null){
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while(true){
            ListNode last = prev;
            ListNode newEnd = current;

            // Check if k nodes are available
            ListNode temp = current;
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    return head;
                }
                temp = temp.next;
            }
    
            ListNode nextD = current.next;

            for(int i = 0; current != null && i < k; i++){
                current.next = prev;
                prev = current;
                current = nextD;
                if(nextD != null){
                    nextD = nextD.next;
                }
            }

            if(last != null){
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;
            if(current == null){
                break;
            }
            prev = newEnd;
        }   
        return head;

    }
}