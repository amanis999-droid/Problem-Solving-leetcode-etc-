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
    public boolean isPalindrome(ListNode head) {

        if(head.next == null){
            return true;
        }
        
        ListNode mid = getMid(head);
        ListNode headSecond = reverseList(mid);
        ListNode reReverseHead = headSecond;

        //compare both halves
        while(head != null && headSecond != null){
            if(head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reReverseHead);

        return head == null || headSecond == null;

        // while(head != null && headSecond != null){
        //     if(head.val != headSecond.val) {
        //         return false;
        //     }
        //     head = head.next;
        //     headSecond = headSecond.next;
        // }
        // return true;
    }

    ListNode getMid(ListNode head){
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode nextD = present.next;
        
        while(present != null){
            present.next = prev;
            prev = present;
            present = nextD;
            if(nextD != null){
                nextD = nextD.next;
            }
        }
        return prev;
    }
}