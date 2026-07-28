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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return head;
        }

        if(head.next == null){
            return head;
        }

        int size = k % size(head);

        while(size != 0){
            ListNode secondLast = get(head);
            ListNode last = secondLast.next;

            last.next = head;
            secondLast.next = null;
            head = last;
            size--;
        }
        return head;
    }

    public int size(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!= null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode get(ListNode head){
        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        return temp;
    }
}