/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps

            if (slow == fast) {
                // Cycle detected, now find the start of the cycle
                // Phase 2: Find the start of the cycle
                ListNode pointer1 = head;
                ListNode pointer2 = slow; // Or fast, since they are at the same node

                while (pointer1 != pointer2) {
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
                // They meet at the start of the cycle
                return pointer1;
            }
        }

        // If the loop finishes without slow == fast, it means no cycle was found
        return null;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna