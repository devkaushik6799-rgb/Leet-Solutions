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
        // Initialize previous pointer to null
        ListNode prev = null;

        // Start from the head of the list
        ListNode temp = head;

        // Traverse the list
        while (temp != null) {
            // Save the next node
            ListNode front = temp.next;

            // Reverse the current node's pointer
            temp.next = prev;

            // Move prev to current node
            prev = temp;

            // Move to the next node
            temp = front;
        }

        // Return new head (last node becomes first)
        return prev;
    }
    public ListNode getKthNode(ListNode temp, int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null){
            ListNode KthNode = getKthNode(temp, k);
          if(KthNode == null){
            if(prevLast != null){
                prevLast.next = temp;
            }
            break;
          }
        ListNode nextNode = KthNode.next;
        KthNode.next = null;
        reverseList(temp);
        if(temp==head){
            head = KthNode;
        } else{
            prevLast.next = KthNode;
        }
        prevLast = temp;
        temp = nextNode;
        }
        return head;
}
   
}

    
