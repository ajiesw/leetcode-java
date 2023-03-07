//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// 👍 683 👎 0

package com.kuer.leetcode.editor.cn;
/**
 * @author kuer
 * 2023-03-07 20:47:06
 */
public class AddStrings{
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("1", "9"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0|| carry != 0){
            if (i >= 0){
                carry = carry + num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0){
                carry = carry + num2.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    private Character[] singleAdd(Character augend, Character addend, Character carry) {
        augend = augend == null ? '0' : augend;
        addend = addend == null ? '0' : addend;
        carry = carry == null ? '0' : carry;
        int add = augend + addend + carry - ('0' << 1) - '0';
        return new Character[]{(char) ('0' + add / 10), (char) ('0' + add % 10)};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}