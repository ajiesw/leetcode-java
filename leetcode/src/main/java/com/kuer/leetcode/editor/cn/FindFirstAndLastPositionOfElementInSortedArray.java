//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 👍 2176 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author kuer
 * 2023-03-05 22:06:12
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1,1,2}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r){
                int mid = (l + r) >> 1;
                if (nums[mid] == target){
                    // 扩大搜寻范围
                    l = r = mid;
                    while (true){
                        boolean lBoolean = l  > 0 && nums[l - 1] == nums[l];
                        boolean rBoolean = r < nums.length - 1 && nums[r + 1] == nums[r];
                        if (lBoolean || rBoolean){
                            if (lBoolean){
                                l--;
                            }else {
                                r++;
                            }
                        }else {
                            return new int[]{l, r};
                        }
                    }
                }
                if (nums[mid] < target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            return new int[] {-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}