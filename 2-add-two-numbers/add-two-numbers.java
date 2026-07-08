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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//Keeping this so i know what dumb things i was doing
        // int carry = 0;
        // ListNode newNode = l1;
        // while(l1 != null && l2 != null && l1.next != null && l2.next != null){
        //     int number = l1.val + l2.val; 
        //     int temp = number;
        //     int digits = 1;
        //     while(temp / 10 != 0){
        //         temp = temp % 10;     [Didn't write but i was updating the number here]
        //         digits++;
        //     }
        //     if(digits > 1){
        //         newNode.next.val = number % 10 + carry;
        //         carry = number / 10;
        //     } else {
        //         newNode.next.val = number + carry;  [adding carry here makes 0 sense]
        //         newNode = newNode.next;
        //     }
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }
        // return newNode;

        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;

        while (l1 != null || l2 != null || carry != 0) {

            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int number = num1 + num2 + carry;

            carry = number / 10;

            newNode.next = new ListNode(number % 10);
            newNode = newNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
        
    }
}