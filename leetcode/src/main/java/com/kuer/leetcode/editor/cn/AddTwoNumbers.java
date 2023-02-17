//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9211 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-02-17 11:12:28
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        l11.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        l21.next = new ListNode(4);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode sum = null;
            sum = loop(l1, l2, sum);
//            addTwoNumbers(sum, l1, l2, false);
            return sum;
        }

        private ListNode loop(ListNode l1, ListNode l2, ListNode sum) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            ListNode lastSum = null;
            boolean carry = false;
            while (carry || node1 != null || node2 != null){
                int val1 = getNodeVal(node1);
                int val2 = getNodeVal(node2);
                int sumVal = carry ? val1 + val2 + 1 : val1 + val2;
                if (sumVal / 10 > 0){
                    carry = true;
                }else {
                    carry = false;
                }
                if (sum == null){
                    sum = new ListNode(sumVal % 10);
                    lastSum = sum;
                }else {
                    lastSum.next = new ListNode(sumVal % 10);
                    lastSum = getNextNode(lastSum);
                }
                node1 = getNextNode(node1);
                node2 = getNextNode(node2);
            }
            return sum;
        }

        private ListNode getNextNode(ListNode node){
            if (node == null){
                return null;
            }
            return node.next;
        }

        private int getNodeVal(ListNode node){
            if (node == null){
                return 0;
            }
            return node.val;
        }

        /**
         *
         * 递归方法
         *
         * @description:
         * @param sum
         * @param carry
         * @param l1
         * @param l2
         * @return:
         * @author: wangkj6
         * @time: 2023/2/17 16:48
         */
        private void addTwoNumbers(ListNode sum,ListNode l1, ListNode l2, boolean carry){
            ListNode l1Next = null;
            ListNode l2Next = null;
            int value1 = 0;
            int value2 = 0;
            if (l1 != null){
                l1Next = l1.next;
                value1 = l1.val;
            }
            if (l2 != null){
                l2Next = l2.next;
                value2 = l2.val;
            }
            int sumValue = carry ? value1 + value2 + 1 : value1 + value2;
            sum.val = sumValue % 10;
            if (sumValue / 10 > 0 || l1Next != null || l2Next != null){
                ListNode next = new ListNode();
                sum.next = next;
                addTwoNumbers(next, l1Next, l2Next, sumValue / 10 > 0);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}

class ListNode {
    int val;
    ListNode next;

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