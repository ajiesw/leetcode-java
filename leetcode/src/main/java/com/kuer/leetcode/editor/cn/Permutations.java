//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 👍 2441 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kuer
 * 2023-03-08 15:24:53
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> paths = new ArrayList<>(nums.length);
//            myMethod(nums, paths, ans);
            optimizeMyMethod(nums, paths, ans, 0);
            return ans;
        }

        private void myMethod(int[] nums, List<Integer> paths, List<List<Integer>> ans) {
            if (paths.size() == nums.length) {
                ans.add(new ArrayList<>(paths));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!exist(nums[i], paths)) {
                    paths.add(nums[i]);
                    myMethod(nums, paths, ans);
                    paths.remove(paths.size() - 1);
                }
            }
        }

        private boolean exist(int num, List<Integer> paths) {
            for (Integer path : paths) {
                if (path == num) {
                    return true;
                }
            }
            return false;
        }

        // 可以对数组分区进行优化，当前遍历的元素左侧是已选元素
        private void optimizeMyMethod(int[] nums, List<Integer> paths, List<List<Integer>> ans, int start) {
            if (paths.size() == nums.length) {
                ans.add(new ArrayList<>(paths));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                paths.add(nums[i]);
                swap(nums, i, start);
                optimizeMyMethod(nums, paths, ans, start + 1);
                swap(nums, i, start);
                paths.remove(paths.size() - 1);
            }
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}