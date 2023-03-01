//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2944 👎 0

package com.kuer.leetcode.editor.cn;

import javax.management.remote.rmi._RMIConnection_Stub;

/**
 * @author kuer
 * 2023-03-01 15:33:26
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        list1.next = list11;
        ListNode list12 = new ListNode(4);
        list11.next = list12;

        ListNode list2 = new ListNode(1);
        ListNode list21 = new ListNode(3);
        list2.next = list21;
        ListNode list22 = new ListNode(4);
        list21.next = list22;
        solution.mergeTwoLists(list1, list2);
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode pc = head;
            while (list1 != null && list2 != null){
                // 将小的插入头结点
                if (list1.val <= list2.val){
                    pc.next = list1;
                    pc = pc.next;
                    list1 = list1.next;
                }else {
                    pc.next = list2;
                    pc = pc.next;
                    list2 = list2.next;
                }
            }
            if (list1 != null){
                pc.next = list1;
            }
            if (list2 != null){
                pc.next = list2;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}