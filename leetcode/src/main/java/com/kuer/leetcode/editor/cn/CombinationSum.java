//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// 👍 2375 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kuer
 * 2023-03-06 17:12:29
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        System.out.println(solution.myMethodDp(new int[]{1, 2, 3, 4}, 8));
//        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{4,2,8}, 8));
        System.out.println(solution.combinationSum(new int[]{8, 7, 4, 3}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            Arrays.sort(candidates);
//            List<List<Integer>> ans = new ArrayList<>();
//            List<Integer> list = new ArrayList<>();
//            myMethod1(list, candidates, target, ans, 0);
//            return ans;
            return myMethodDp(candidates, target);
        }

        /**
         * 无法去重
         * 排序需要时间看如何操作
         * 如果进行排序（可以剪枝）添加起始循环值可以实现去重（只遍历大于等于当前值的）
         * 如果不排序 直接全遍历 去重通过不遍历之前的元素实现
         * @param list
         * @param candidates
         * @param target
         * @param ans
         */
        private void myMethod1(List<Integer> list, int[] candidates, int target, List<List<Integer>> ans, int startIndex) {
            for (int i = startIndex; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (candidate == target) {
                    list.add(candidate);
                    ans.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                } else if (target > candidate) {
                    list.add(candidate);
                    myMethod1(list, candidates, target - candidate, ans, i);
                    list.remove(list.size() - 1);
                }
            }
        }

        /**
         * 使用动态规划
         *
         * @param candidates
         * @param target
         */
        private List<List<Integer>> myMethodDp(int[] candidates, int target) {
            Arrays.sort(candidates);
            // 从1到target的数据
            Set<List<Integer>>[] dp = new Set[target];
            for (int i = 0; i < dp.length; i++) {
                // 获得i + 1的组合
                dp[i] = new HashSet<>();
                for (int j = 0; j < candidates.length; j++) {
                    int tempTarget = i + 1;
                    if (candidates[j] <= tempTarget){
                        if (candidates[j] == tempTarget){
                            List<Integer> list = new ArrayList<>();
                            list.add(candidates[j]);
                            dp[i].add(list);
                        }else {
                            int find = tempTarget - candidates[j] - 1;
                            if (!dp[find].isEmpty()){
                                for (List<Integer> integers : dp[find]) {
                                    List<Integer> e = new ArrayList<>(integers);
                                    e.add(candidates[j]);
                                    // 需要去重
                                    // 方法一使用set，对set元素进行排序
                                    e.sort(Comparator.comparingInt(a -> a));
                                    dp[i].add(e);
                                }
                            }
                        }
                    }else {
                        break;
                    }
                }
            }
            return new ArrayList<>(dp[target - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}