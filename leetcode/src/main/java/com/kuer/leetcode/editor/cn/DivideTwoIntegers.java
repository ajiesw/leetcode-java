//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1072 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-03-01 21:24:08
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
//        System.out.println(solution.divide(10, 3));
//        System.out.println(solution.divide(18, 3));
//        System.out.println(solution.divide(1038925803, -2147483648));
//        System.out.println(solution.divide(-3, -2147483648));
//        System.out.println(solution.divide(-2147483648, -3));
//        System.out.println(solution.divide(10, 3));
//        System.out.println(solution.divide(10, 5));
//        System.out.println(solution.divide(10, -3));
//        System.out.println(solution.divide(10, -5));
//        System.out.println(solution.divide(-10, 3));
//        System.out.println(solution.divide(-10, 5));
//        System.out.println(solution.divide(-10, -3));
//        System.out.println(solution.divide(-10, -5));
//        System.out.println(solution.divide(1004958205, -2137325331));
//        System.out.println(solution.divide(2147483647, 3));
//        System.out.println(solution.divide(-2147483648, 2));
        System.out.println(solution.fastMultChange(Integer.MIN_VALUE + 1, Integer.MAX_VALUE/3, -1));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            return leetCode(dividend, divisor);
//            int count = divisor;
//            int leftMove = 0;
//            int addNum = 0;
//            while (dividend >= divisor + (count << addNum)){
//                leftMove++;
//                if (divisor << leftMove < dividend){
//                    addNum++;
//                }
//                divisor <<= 1;
//            }
//            return addNum > 0 ? (1 << leftMove) + (1 << addNum) : (1 << leftMove);
        }

        private int leetCode(int dividend, int divisor){
            // 由题意得商只能落在零到被除数区间内，用二分法查找
            // 为了避免越界将所有数都转换在负数内操作
            int ans = 0;
            if (dividend == 0){
                return 0;
            }
            if (dividend == Integer.MIN_VALUE){
                if (divisor == 1){
                    return Integer.MIN_VALUE;
                } else if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            if (divisor == Integer.MIN_VALUE){
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            boolean positive = true;
            if (dividend > 0){
                positive = !positive;
                dividend = -dividend;
            }
            if (divisor > 0){
                positive = !positive;
                divisor = -divisor;
            }
            // l为0，当被除数为Integer.MIN_VALUE会出现溢出，
            int l = 1;
            int r = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            while (l <= r){
                int mid = l + ((r - l) >> 1);
                // 除数乘mid为负 被除数也为负 如果乘积大于被除数说明目标在右侧
                // a/b >= c a,b<0
                // a <= bc

                // 这里处理有问题，如果divisor足够小 乘数在合适的区间内会导致负数乘正数结果为正
                // (Integer.MIN_VALUE + 1) * (Integer.MAX_VALUE/3)
                int mult = fastMult(divisor, mid);
                if (fastMultChange(divisor, mid, dividend)){
                    ans = mid;
                    if (mid == Integer.MAX_VALUE){
                        break;
                    }
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            return positive ? ans : -ans;
        }


        /**
         * 快速乘，不使用乘除法
         * 3 * 5
         * 3 + 3 + 3 + 3 + 3
         * [(3 + 3) + (3 + 3)] + 3 可以分成两部分[(3 + 3) + (3 + 3)] 和 3，将第二部分累加起来为sum
         * (6 + 6) + sum
         * 12 + sum
         * @param a
         * @param b
         * @return
         */
        private int fastMult(int a, int b){
            int ans = 0;
            if (a == 0 || b == 0){
                return ans;
            }
            boolean positive = true;
            if (a < 0){
                positive = !positive;
                a = -a;
            }
            if (b < 0){
                positive = !positive;
                b = -b;
            }
            if (b > a){
                int temp = a;
                a = b;
                b = temp;
            }
            while (b >= 1){
                // 如果
                if ((b & 1) == 1){
                    ans += a;
                }
                a = a << 1;
                b >>= 1;
            }
            return positive ? ans : -ans;
        }

        /**
         * 快速乘，变体
         * 判断a * b >= c是否成立
         * a c为负
         * @param a
         * @param b
         * @return
         */
        private boolean fastMultChange(int a, int b, int c){
            int ans = 0;
            while (b >= 1){
                // 如果
                if ((b & 1) == 1){
                    // 判断后半部分大于c
                    // ans + a >= c

                    if (ans < c - a){
                        return false;
                    }
                    ans += a;
                }
                if (b != 1){
                    // 判断前半部分是否大于c
                    // a + a防止溢出改为 c - a
                    if (a < c - a){
                        return false;
                    }
                    a = a << 1;
                }
                b >>= 1;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}