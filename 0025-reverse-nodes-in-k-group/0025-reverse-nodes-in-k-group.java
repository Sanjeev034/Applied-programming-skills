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
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode tail = curr;
            int count = 0;
            // Check if there are k nodes remaining
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }

            // If there are k nodes, reverse the group
            if (count == k) {
                ListNode nextGroupStart = tail;
                ListNode reversedHead = reverseList(curr, k);

                // Connect the previous group to the reversed group
                prev.next = reversedHead;
                // Connect the reversed group's tail to the next group
                curr.next = nextGroupStart;

                // Move pointers for the next iteration
                prev = curr;
                curr = nextGroupStart;
            } else {
                // If less than k nodes remain, break the loop
                break;
            }
        }

        return dummy.next;
    }

    // Helper function to reverse k nodes starting from 'node'
    private ListNode reverseList(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 'prev' is the new head of the reversed list
        // 'node' is now the tail of the reversed list
        return prev;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna