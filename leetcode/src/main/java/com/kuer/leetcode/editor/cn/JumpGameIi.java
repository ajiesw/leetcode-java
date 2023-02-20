//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1958 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-02-20 19:59:13
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{1,1,1,1}));
//        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
//        System.out.println(solution.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            return dp(nums);

        }

        private int greedy(int[] nums) {
            int num = 0;
            int maxJump;
            int maxIndex = 0;
            for (int i = 0; maxIndex < nums.length - 1; i = maxIndex) {
                maxJump = nums[i] + i;
                int subLength = nums[i];
                if (maxJump >= nums.length - 1){
                    return ++num;
                }
                for (int j = 0; j < subLength; j++) {
                    int tempJump = nums[i + j + 1] + i + j + 1;
                    if (tempJump >= maxJump){
                        maxJump = tempJump;
                        maxIndex = i + j + 1;
                    }
                }
                num++;
            }
            return num;
        }

        private int dp(int[] nums){
            if (nums.length <= 1){
                return 0;
            }
            int[] maxJump = new int[nums.length];
            int lastIndex = -1;
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                maxJump[i] = nums[i] + i;
                if (maxJump[i] >= nums.length - 1 && lastIndex == -1){
                    lastIndex = i;
                    num++;
                }
            }
            for (int i = 0; i < lastIndex; ) {
                if (maxJump[i] >= lastIndex){
                    num++;
                    if (i == 0){
                        break;
                    }
                    lastIndex = maxJump[i];
                    i = 0;
                }else {
                    i++;
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}