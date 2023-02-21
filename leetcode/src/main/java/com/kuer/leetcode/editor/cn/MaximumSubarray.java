//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 5725 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-02-21 14:02:30
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            return method1(nums);
        }

        private int dp(int[] nums){
            // Memory Limit Exceeded
            // dp[i][j]表示从i加到j的和
            int[][] dp = new int[nums.length][nums.length];
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    } else {
                        dp[i][j] = dp[i][j - 1] + nums[j];
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }

        private int dp2(int[] nums){
            int max = nums[0];
            // dp[i]表示以i结尾的子串的最大和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] + nums[i] < nums[i]){
                    dp[i] = nums[i];
                }else {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        private int method1(int[] nums){
            int max = nums[0];
            int sum = nums[0];
            int left = 0;
            int right = 0;
            while (right < nums.length){
                if (sum <= 0){
                    max = Math.max(max, nums[right]);
                    left = ++right;
                    if (right < nums.length){
                        sum = nums[right];
                    }
                }else {
                    right++;
                    if (right < nums.length){
                        sum += nums[right];
                    }
                }
                max = Math.max(sum, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}