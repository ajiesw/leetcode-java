//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 👍 3086 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuer
 * 2023-02-19 19:05:56
 */
public class GenerateParentheses{
  public static void main(String[] args) {
    Solution solution = new GenerateParentheses().new Solution();
      System.out.println(solution.generateParenthesis(3));
  }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        return method2(n);
    }


    private List<String> method1(int n) {
        List<String> ans = new ArrayList<>();
        int length = n << 1;
        generate(ans, "", 0, length);
        return ans;
    }

    private void generate(List<String> ans, String str, int more, int length){
        if (str.length() == length){
            ans.add(str);
            return;
        }
        if (more == 0){
            generate(ans, str + "(", more + 1, length);
        }else if (more >= length - str.length()){
            generate(ans, str + ")", more - 1, length);
        }else {
            generate(ans, str + "(", more + 1, length);
            generate(ans, str + ")", more - 1, length);
        }
    }

    private List<String> method2(int n){
        List<String>[] pList = new List[n + 1];
        pList[0] = new ArrayList<String>(){{add("");}};
        pList[1] = new ArrayList<String>(){{add("()");}};
        // 获取第二层到第n层的括号
        for (int i = 2; i <= n; i++) {
            // 括号从由n = p + q + 1组成
            List<String> pTemp = new ArrayList<>();
            for (int q = 0; q < i; q++) {
                List<String> qs = pList[q];
                List<String> ps = pList[i - 1 - q];
                qs.forEach(e -> {
                    ps.forEach(f -> {
                        pTemp.add("(" + e + ")" + f);
                    });
                });
            }
            pList[i] = pTemp;
        }
        return pList[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}