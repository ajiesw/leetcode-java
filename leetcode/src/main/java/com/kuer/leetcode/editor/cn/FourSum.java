//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1514 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kuer
 * 2023-02-28 17:44:09
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println(solution.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            myMethod1(ans, nums, target);
            return ans;
        }

        private void myMethod1(List<List<Integer>> ans, int[] nums, int target) {
            if (nums.length < 4) {
                return;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (target > 0 && nums[nums.length - 1] < 0){
                    break;
                }
                if (target < 0 && nums[i] > 0){
                    break;
                }
                int tempTarget = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int b = nums[j];
                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r) {
                        // 大于 r向左移动
                        if (b + nums[l] + nums[r] > tempTarget) {
                            while (l < r && nums[r] == nums[r - 1]){
                                r--;
                            }
                            r--;
                        } else if (b + nums[l] + nums[r] < tempTarget) {
                        // 小于 l向右移动
                            while (l < r && nums[l] == nums[l + 1]){
                                l++;
                            }
                            l++;
                        } else {
                            // 等于 l右移
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            ans.add(list);
                            while (l < r && nums[l] == nums[l + 1]){
                                l++;
                            }
                            l++;
                        }
                    }
                    while (j < nums.length - 2 && nums[j] == nums[j + 1]){
                        j++;
                    }
                }
                while (i < nums.length - 3 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}