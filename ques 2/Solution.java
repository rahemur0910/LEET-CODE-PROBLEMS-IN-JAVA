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
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;
        int carry = 0;

        while (num1 != null || num2 != null) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.val;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.val;
                num2 = num2.next;
            }
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

