//题目：
//        输入一个链表的头节点，从尾到头反过来打印出每个节点的值。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] print = new int[stack.size()];
        for (int i = 0; i < print.length; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
