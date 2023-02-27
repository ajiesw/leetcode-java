//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2648 👎 0

package com.kuer.leetcode.editor.cn;
/**
 * @author kuer
 * 2023-02-24 14:47:42
 */
public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String preFix = "";
        if (strs == null || strs.length == 0){
            return preFix;
        }
        preFix = strs[0];
        for (String str : strs) {
            if ("".equals(preFix)){
                break;
            }
            while (!str.startsWith(preFix)){
                preFix = preFix.substring(0, preFix.length() - 1);
            }
        }
        return preFix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}