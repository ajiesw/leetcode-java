//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2423 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-03-01 14:38:56
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();
        Solution solution = list.new Solution();
        ListNode head = list.new ListNode(1);
        ListNode node2 = list.new ListNode(2);
        head.next = node2;
//        ListNode node3 = list.new ListNode(3);
//        node2.next = node3;
//        ListNode node4 = list.new ListNode(4);
//        node3.next = node4;
//        ListNode node5 = list.new ListNode(5);
//        node4.next = node5;
        System.out.println(solution.removeNthFromEnd(head, 1));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = head;
            int pc = 0;
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }
            temp = head;
            if (n == length) {
                return head.next;
            }
            for (; pc <= length - n; pc++) {
                // 如果pc移动到了需要删除的位置
                if (pc == length - n - 1) {
                    temp.next = temp.next == null ? null : temp.next.next;
                    break;
                }
                temp = temp.next;
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}