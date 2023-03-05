//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2085 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author kuer
 * 2023-03-04 23:08:26
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {5,4,7,5,3,2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int tag = -1;
            for (int i = nums.length - 1; i > 0; i--) {
                // 记录找到向下的拐点
                if (nums[i] <= nums[i - 1]){
                    tag = i -1;
                }else {
                    // 如果最后两位数是升序则只需要交换
                    if (tag == -1){
                        swap(nums, i, i - 1);
                        return;
                    } else {
                        for (int j = nums.length - 1; j >= tag; j--) {
                            if (nums[tag - 1] < nums[j]){
                                swap(nums, tag - 1, j);
                                // 倒序输出
                                reverse(nums, tag, nums.length - 1);
                                return;
                            }
                        }
                    }
                }
                if (tag == 0) {
                    // 倒序输出
                    reverse(nums, 0, nums.length - 1);
                    return;
                }
            }
        }

        private void swap(int[] nums, int tag, int j) {
            int temp = nums[tag];
            nums[tag] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start, int end){
            for (int i = start, j = 0; i <= (start + end) >> 1; i++, j++) {
                swap(nums, i, end - j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}