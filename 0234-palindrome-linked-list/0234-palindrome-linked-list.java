class Solution {
    public ListNode reverseLinkedlist(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedlist(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode newHead = reverseLinkedlist(slow.next);

        // 3. Compare the two halves
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverseLinkedlist(newHead); // restore original list
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // 4. Restore original list before returning
        reverseLinkedlist(newHead);
        return true;
    }
}