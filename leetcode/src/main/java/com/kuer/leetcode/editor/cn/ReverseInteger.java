//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3766 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author kuer
 * 2023-02-22 11:05:14
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(1563847412));
        System.out.println(solution.reverse(2147483647));
        System.out.println(solution.reverse(-2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            boolean positive = x > 0;
            if (positive) {
                x = -x;
            }
            Stack<Integer> stack = new Stack<>();
            while (x / 10 != 0) {
                int i = x % 10;
                stack.push(i);
                x /= 10;
            }
            stack.push(x);
            int result = 0;
            int j = 1;
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if ((1000000000 == j && pop < -2)|| Integer.MIN_VALUE - result > pop * j){
                    return 0;
                }
                result += pop * j;
                j *= 10;
            }
            return positive ? -result : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}