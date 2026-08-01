/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node temp = head;
        Node newList = new Node(temp.val);

        Node temp2 = newList;
        temp = temp.next;
        while(temp != null){
            Node node = new Node(temp.val);
            temp2.next = node;
            temp = temp.next;
            temp2 = node;
        }
        //assigning random pointer fahh
        Node temp3 = head;
        Node newTemp = newList;

        while (temp3 != null) {
            if (temp3.random == null) {
                newTemp.random = null;
            } else {
                int index = getIndex(head, temp3.random);
                newTemp.random = get(newList, index);
            }

            temp3 = temp3.next;
            newTemp = newTemp.next;
        }

        return newList;

        //Method 2: 
        // while(temp != null){

        //     if(temp.next == null){
        //         Node newNode = new Node(temp.val);
        //         temp.next = newNode;
        //         temp = newNode;
        //         return head;
        //     }
           
        //     Node newNode = new Node(temp.val);
        //     newNode.next = temp.next;
        //     Node a = temp.next;
        //     temp.next = newNode;
        //     temp = a;
            
        // }

        // return head;

    }

    public Node get(Node head, int index) {
        Node temp = head;

        while (index > 0) {
            temp = temp.next;
            index--;
        }

        return temp;
    }

    public int getIndex(Node head, Node target) {
        int index = 0;
        Node temp = head;

        while (temp != null) {
            if (temp == target) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }
}