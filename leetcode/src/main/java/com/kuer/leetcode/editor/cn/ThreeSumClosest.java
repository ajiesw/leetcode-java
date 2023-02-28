//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1340 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author kuer
 * 2023-02-27 23:57:55
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0,1,2}, 3));
        System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int close = Integer.MAX_VALUE;
            int minSum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (Math.abs(sum - target) < close){
                        close = Math.abs(sum - target);
                        minSum = sum;
                    }
                    if (sum < target){
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        l++;
                    } else if (sum > target) {
                        while (l < r && nums[r] == nums[r - 1]){
                            r--;
                        }
                        r--;
                    }else {
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        l++;
                    }
                }
                while (i < nums.length - 2 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
            return minSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}