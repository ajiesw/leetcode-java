//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// 👍 1160 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.*;

/**
 * @author kuer
 * 2023-03-07 16:18:34
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
//        System.out.println(solution.charMultiplyString('3', "456"));
        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("123456789", "987654321"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)){
                return "0";
            }
            String ans = "";
            for (int i = num1.length() - 1; i >= 0; i--) {
                StringBuilder augend = charMultiplyString(num1.charAt(i), num2);
                for (int j = 0; j < num1.length() - 1 - i; j++) {
                    augend.append('0');
                }
                ans = stringAdd(ans, augend.toString());
            }
            return ans;
//            return myStupidMethod(num1, num2);
        }

        private String myStupidMethod(String num1, String num2) {
            List<Queue<Character>> addList = new ArrayList<>();
            for (int i = num1.length() - 1; i >= 0; i--) {
                char multiplier = num1.charAt(i);
                Character[] characters = {'0', '0'};
                Queue<Character> queue = new LinkedList<>();
                for (int k = 0; k < num1.length() - 1 - i; k++) {
                    queue.add('0');
                }
                for (int j = num2.length() - 1; j >= 0; j--) {
                    char multiplicand = num2.charAt(j);
                    characters = singleMultiply(multiplicand, multiplier, characters[0]);
                    queue.add(characters[1]);
                }
                if (characters[0] != '0'){
                    queue.add(characters[0]);
                }
                addList.add(queue);
            }
            StringBuilder sb = new StringBuilder();
            Queue<Character> dis = new LinkedList<>();
            Queue<Character> disTemp = new LinkedList<>();
            while (!addList.isEmpty()){
                Queue<Character> remove = addList.remove(0);
                Character[] characters = {'0', '0'};
                while (true){
                    if (!dis.isEmpty() || !remove.isEmpty()){
                        characters = singleAdd(dis.poll(), remove.poll(), characters[0]);
                        disTemp.add(characters[1]);
                        if (characters[0] != '0' && remove.isEmpty()){
                            disTemp.add(characters[0]);
                        }
                    }else {
                        dis.addAll(disTemp);
                        disTemp.clear();
                        break;
                    }
                }
            }
            dis.forEach(e -> sb.insert(0, e));
            return sb.toString();
        }

        private Character[] singleMultiply(Character multiplicand, Character multiplier, Character carry) {
            int product = (multiplicand - '0') * (multiplier - '0') + carry - '0';
            char p = (char) ('0' + product % 10);
            return new Character[]{(char) ('0' + (product / 10)), p};
        }

        private Character[] singleAdd(Character augend, Character addend, Character carry) {
            augend = augend == null ? '0' : augend;
            addend = addend == null ? '0' : addend;
            carry = carry == null ? '0' : carry;
            int add = augend + addend + carry - ('0' << 1) - '0';
            return new Character[]{(char) ('0' + add / 10), (char) ('0' + add % 10)};
        }

        private String stringAdd(String str1, String str2){
            StringBuilder sb = new StringBuilder();
            int carry = 0, i = str1.length() - 1, j = str2.length() - 1;
            while (carry != 0 || i >= 0 || j >= 0){
                if (i >= 0){
                    carry += str1.charAt(i--) - '0';
                }
                if (j >= 0){
                    carry += str2.charAt(j--) - '0';
                }
                sb.append(carry % 10);
                carry /= 10;
            }
            return sb.reverse().toString();
        }

        private StringBuilder charMultiplyString(Character character, String str){
            int multiplier = character - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            int i = str.length() - 1;
            while (i >= 0 || carry != 0) {
                if (i >= 0){
                    carry += multiplier * (str.charAt(i--) - '0');
                }
                sb.append(carry % 10);
                carry /= 10;
            }
            return sb.reverse();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}