class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Stop at the last node so tail is not null
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Handle cases where rotation equals 0
        k = k % length;
        if (k == 0) return head;

        // 3. Form a circular list
        tail.next = head;

        // 4. Advance (length - k - 1) times to reach the new tail
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the ring
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}