//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// 👍 2859 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author kuer
 * 2023-02-19 16:14:20
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            return array(n);
        }

        private Integer hashMap(int n) {
            HashMap<Integer, Integer> stepMap = new HashMap<>(16);
            stepMap.put(1, 1);
            stepMap.put(2, 2);
            for (int i = 2; i <= n; i++) {
                if (!stepMap.containsKey(i)) {
                    stepMap.put(i, stepMap.get(i - 1) + stepMap.get(i - 2));
                }
            }
            return stepMap.get(n);
        }
        private Integer array(int n) {
            if (n <= 2){
                return n;
            }
            int[] stepArray = new int[n];
            stepArray[0] = 1;
            stepArray[1] = 2;
            for (int i = 2; i < n; i++) {
                if (stepArray[i] == 0) {
                    stepArray[i] = stepArray[i - 1] + stepArray[i -2];
                }
            }
            return stepArray[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}