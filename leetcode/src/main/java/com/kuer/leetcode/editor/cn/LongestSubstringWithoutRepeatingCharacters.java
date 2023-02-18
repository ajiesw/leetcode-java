//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8725 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kuer
 * 2023-02-17 17:15:56
 */
public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      int max = solution.lengthOfLongestSubstring("bbbbb");
      System.out.println(max);
  }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return getMaxCount(s);
    }

    private int getMaxLoop(String s) {
        int max = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            Set<Character> set = new HashSet<>();
            int tempMax = 0;
            int setsize = 0;
            while (setsize == tempMax && i + tempMax <= s.length() -1){
                set.add(s.charAt(i + tempMax));
                tempMax ++;
                setsize = set.size();
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    private int getMaxCount(String s){
        int max = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> windows = new HashMap<>(16);
        while (right <= s.length() - 1){
            char c = s.charAt(right);
            if (!windows.containsKey(c)){
                windows.put(c, right);
            }else {
                Integer index = windows.get(c);
                max = Math.max(max, windows.size());
                windows.clear();
                for (int i = index + 1; i <= right; i++) {
                    windows.put(s.charAt(i), i);
                }
            }
            right++;
        }
        if (windows.size() == s.length()){
            max = windows.size();
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}