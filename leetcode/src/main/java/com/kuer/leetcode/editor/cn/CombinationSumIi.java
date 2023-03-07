//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 👍 1262 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kuer
 * 2023-03-07 01:26:37
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(solution.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            // 通过排序实现去重
            Arrays.sort(candidates);
//            flashBack(candidates, target, ans, new ArrayList<>(), 0);
//            return ans;
            return dynamicProgram(candidates, target);
        }

        // 两种思路回溯+剪枝
        private void flashBack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int start){
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (candidate < target){
                    path.add(candidate);
                    flashBack(candidates, target - candidate, ans, path, i + 1);
                    path.remove(path.size() - 1);
                }else if (candidate == target){
                    path.add(candidate);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    break;
                }else {
                    break;
                }
                // 剪枝
                while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
                    i++;
                }
            }
        }
        // 动态规划
        private List<List<Integer>> dynamicProgram(int[] candidates, int target){
            // 0 ~ target对应的组合,和前一题类似需要对dp进行去重
            List<List<Integer>>[] dp = new List[target];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<>();
                int temp = i + 1;
                for (int j = 0; j < candidates.length; j++) {
                    int currentData = candidates[j];
                    if (currentData == temp){
                        ArrayList<Integer> element = new ArrayList<>();
                        element.add(currentData);
                        dp[i].add(element);
                        break;
                    } else if (temp > currentData) {
                        if (dp[temp - currentData - 1] != null){
                            List<List<Integer>> smallList = dp[temp - currentData - 1];
                            for (int k = 0; k < smallList.size(); k++) {
                                List<Integer> list = smallList.get(k);
                                ArrayList<Integer> element = new ArrayList<>(list);
                                element.add(currentData);
                                dp[i].add(element);
                            }
                        }
                    }else {
                        break;
                    }
                    while (j + 1 < candidates.length && candidates[j] == candidates[j + 1]){
                        j++;
                    }
                }
            }
            return dp[target - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}