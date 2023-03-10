//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
//
// Related Topics 哈希表 数学 字符串 👍 1059 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kuer
 * 2023-02-23 20:01:06
 */
public class IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1994));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
        return myMethod1(num);
    }

    private String myMethod1(int num){
        StringBuilder ans = new StringBuilder();
        while (num > 0){
            if (num / 1000 > 0){
                int i = num / 1000;
                for (int j = 0; j < i; j++) {
                    ans.append("M");
                }
                num %= 1000;
            } else if (num / 900 > 0) {
                int i = num / 900;
                for (int j = 0; j < i; j++) {
                    ans.append("CM");
                }
                num %= 900;
            } else if (num / 500 > 0) {
                int i = num / 500;
                for (int j = 0; j < i; j++) {
                    ans.append("D");
                }
                num %= 500;
            } else if (num / 400 > 0) {
                int i = num / 400;
                for (int j = 0; j < i; j++) {
                    ans.append("CD");
                }
                num %= 400;
            } else if (num / 100 > 0) {
                int i = num / 100;
                for (int j = 0; j < i; j++) {
                    ans.append("C");
                }
                num %= 100;
            } else if (num / 90 > 0) {
                int i = num / 90;
                for (int j = 0; j < i; j++) {
                    ans.append("XC");
                }
                num %= 90;
            } else if (num / 50 > 0) {
                int i = num / 50;
                for (int j = 0; j < i; j++) {
                    ans.append("L");
                }
                num %= 50;
            } else if (num / 40 > 0) {
                int i = num / 40;
                for (int j = 0; j < i; j++) {
                    ans.append("XL");
                }
                num %= 40;
            } else if (num / 10 > 0) {
                int i = num / 10;
                for (int j = 0; j < i; j++) {
                    ans.append("X");
                }
                num %= 10;
            } else if (num / 9 > 0) {
                int i = num / 9;
                for (int j = 0; j < i; j++) {
                    ans.append("IX");
                }
                num %= 9;
            } else if (num / 5 > 0) {
                int i = num / 5;
                for (int j = 0; j < i; j++) {
                    ans.append("V");
                }
                num %= 5;
            } else if (num / 4 > 0) {
                int i = num / 4;
                for (int j = 0; j < i; j++) {
                    ans.append("IV");
                }
                num %= 4;
            } else if (num > 0){
                for (int i = 0; i < num; i++) {
                    ans.append("I");
                }
                num = 0;
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}