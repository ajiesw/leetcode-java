//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 1761 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-03-01 17:47:55
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        System.out.println(solution.strStr("mississippi", "issipi"));
        System.out.println(solution.strStr("a", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            // fun
//            return haystack.indexOf(needle);
            if (needle.length() > haystack.length()){
                return -1;
            }
            int l = 0;
            int length = needle.length();
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                if (haystack.charAt(i) == needle.charAt(l)){
                    while (l < length) {
                        if (haystack.charAt(i + l) == needle.charAt(l)){
                            l++;
                        }else {
                            l = 0;
                            break;
                        }
                    }
                    if (l == length){
                        return i;
                    }
                    l = 0;
                }else {
                    l = 0;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}