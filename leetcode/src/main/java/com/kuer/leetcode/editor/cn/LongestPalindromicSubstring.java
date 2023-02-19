//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6152 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-02-19 01:30:01
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String str = "ccc";
        System.out.println(solution.dynamicProgramming(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return dynamicProgramming2(s);
        }

        private String bruteForce(String s) {
            int length = s.length();
            String subStr = "";
            for (int i = 0; i < length; i++) {
                for (int winLength = 1; winLength + i <= s.length(); winLength++) {
                    String substring = s.substring(i, i + winLength);
                    if (isPalindrome(substring, substring.length()) && substring.length() > subStr.length()) {
                        subStr = substring;
                    }
                }
            }
            return subStr;
        }

        public boolean isPalindrome(String s, int length) {
            if (length == 1) {
                return true;
            }
            // 奇数
            int mid = length >> 1;
            if ((length & 0x1) == 0x1) {
                for (int i = 0; mid + i < s.length(); i++) {
                    if (s.charAt(mid - i) != s.charAt(mid + i)) {
                        return false;
                    }
                }
                return true;
            } else {
                // 偶数
                for (int i = 0; mid + i < s.length(); i++) {
                    if (s.charAt(mid + i) != s.charAt(mid - i - 1)) {
                        return false;
                    }
                }
                return true;
            }
        }

        public String dynamicProgramming(String s) {
            if (s == null) {
                return s;
            }
            int length = s.length();
            if (length < 2) {
                return s;
            }
            boolean[][] dpArray = new boolean[length][length];
            int maxLeft = 0;
            int maxRight = 0;
            int max = 1;
            for (int right = 1; right < length; right++) {
                for (int left = 0; left < right; left++) {
                    boolean rightEqualsLeft = s.charAt(left) == s.charAt(right);
                    if (rightEqualsLeft && (left + 1 == right || left + 2 == right)) {
                        dpArray[left][right] = true;
                        if (right - left + 1 > max) {
                            max = right - left + 1;
                            maxRight = right;
                            maxLeft = left;
                        }
                    }
                    if (left + 1 == right - 1) {
                        dpArray[left + 1][right - 1] = true;
                    }
                    if (rightEqualsLeft && dpArray[left + 1][right - 1]) {
                        dpArray[left][right] = true;
                        if (right - left + 1 > max) {
                            max = right - left + 1;
                            maxRight = right;
                            maxLeft = left;
                        }
                    }
                }
            }
            return s.substring(maxLeft, maxRight + 1);
        }

        public String dynamicProgramming2(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int strLen = s.length();
            int maxStart = 0; //最长回文串的起点
            int maxEnd = 0;//最长回文串的终点
            int maxLen = 1; //最长回文串的长度
            boolean[][] dp = new boolean[strLen][strLen];
            for (int r = 1; r < strLen; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            maxStart = l;
                            maxEnd = r;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}