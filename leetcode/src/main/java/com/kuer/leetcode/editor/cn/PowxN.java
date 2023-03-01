//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1126 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-03-01 23:00:08
 */
public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(-1.0, 2147483647));
        System.out.println(solution.myPow(2.0, -2147483648));
        System.out.println(solution.myPow(2.0, 10));
        System.out.println(solution.myPow(2.0, -2));
        System.out.println(solution.myPow(2.1, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double pow = 1.0;
            if (n == 0){
                return pow;
            }
            if (x == 1.0){
                return 1.0;
            }
            if (x == -1.0){
                return n % 2 == 0 ? -x : x;
            }
            if (n == Integer.MIN_VALUE){
                return 0;
            }
            if (n < 0){
                n = -n;
                x = 1 / x;
            }
            for (int i = 0; i < n; i++) {
                pow *= x;
            }
            return pow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}