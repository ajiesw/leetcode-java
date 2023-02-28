//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2327 👎 0

package com.kuer.leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @author kuer
 * 2023-02-28 14:58:25
 */
public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ans;
        }
        Map<Character, List<String>> phoneMap = new HashMap<>(16);
        generatePhone(phoneMap);
//        method(digits, ans, 0, new StringBuilder(), phoneMap);
        method2(digits, ans, 0, "", phoneMap);
//        ans = leetCode1(digits, phoneMap);
        return ans;
    }

    private void generatePhone(Map<Character, List<String>> phoneMap) {
        phoneMap.put('2', new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        });
        phoneMap.put('3', new ArrayList<String>(){
            {
                add("d");
                add("e");
                add("f");
            }
        });
        phoneMap.put('4', new ArrayList<String>(){
            {
                add("g");
                add("h");
                add("i");
            }
        });
        phoneMap.put('5', new ArrayList<String>(){
            {
                add("j");
                add("k");
                add("l");
            }
        });
        phoneMap.put('6', new ArrayList<String>(){
            {
                add("m");
                add("n");
                add("o");
            }
        });
        phoneMap.put('7', new ArrayList<String>(){
            {
                add("p");
                add("q");
                add("r");
                add("s");
            }
        });
        phoneMap.put('8', new ArrayList<String>(){
            {
                add("t");
                add("u");
                add("v");
            }
        });
        phoneMap.put('9', new ArrayList<String>(){
            {
                add("w");
                add("x");
                add("y");
                add("z");
            }
        });
    }

    private void method(String digits, List<String> ans, int num, StringBuilder record, Map<Character, List<String>> phoneMap){
        char c = digits.charAt(num);
        List<String> strings = phoneMap.get(c);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            // 如果是最后一个字符
            if (num >= digits.length() - 1){
                record.append(s);
                ans.add(record.toString());
            }else {
                record.append(s);
                method(digits, ans, num + 1, record, phoneMap);
            }
            record.delete(record.length() - 1, record.length());
        }
    }
    private void method2(String digits, List<String> ans, int num, String record, Map<Character, List<String>> phoneMap){
        char c = digits.charAt(num);
        List<String> strings = phoneMap.get(c);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            // 如果是最后一个字符
            if (num >= digits.length() - 1){
                ans.add(record + s);
            }else {
                method2(digits, ans, num + 1, record + s, phoneMap);
            }
        }
    }

    private List<String> leetCode1(String digits, Map<Character, List<String>> phoneMap){
        LinkedList<String> ans = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            char s = digits.charAt(i);
            List<String> strings = phoneMap.get(s);
            if (ans.isEmpty()){
                for (String string : strings) {
                    ans.push(string);
                }
            }else {
                int size = ans.size();
                for (int j = 0; j < size; j++) {
                    String temp = ans.remove();
                    for (String string : strings) {
                        ans.add(temp + string);
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}