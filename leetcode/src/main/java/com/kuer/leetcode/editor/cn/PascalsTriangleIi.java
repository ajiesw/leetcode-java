//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// 👍 460 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuer
 * 2023-02-19 18:33:22
 */
public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                if (i == 0) {
                    row.add(1);
                } else {
                    for (int j = 0; j <= i; j++) {
                        if (j == 0 || j == i) {
                            row.add(1);
                        } else {
                            List<Integer> upRow = lists.get(i - 1);
                            row.add(upRow.get(j - 1) + upRow.get(j));
                        }
                    }
                }
                lists.add(row);
            }
            return lists.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}