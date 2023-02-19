//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// 👍 911 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuer
 * 2023-02-19 18:18:27
 */
public class PascalsTriangle{
  public static void main(String[] args) {
    Solution solution = new PascalsTriangle().new Solution();
      System.out.println(solution.generate(1));
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if (i == 0){
                row.add(1);
            }else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i){
                        row.add(1);
                    }else {
                        List<Integer> upRow = lists.get(i - 1);
                        row.add(upRow.get(j - 1) + upRow.get(j));
                    }
                }
            }
            lists.add(row);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}