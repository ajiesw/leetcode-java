//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// 👍 2514 👎 0

package com.kuer.leetcode.editor.cn;

/**
 * @author kuer
 * 2023-03-05 18:57:11
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{5, 1, 3}, 5));
        System.out.println(solution.search(new int[]{3,5,1}, 3));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r){
                int mid = (l + r) >> 1;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[r] == target){
                    return r;
                }

                // 是经过旋转的数组
                if (nums[l] > nums[r]) {
                    // 如果mid在升序部分
                    if (nums[mid] > nums[l]){
                        // 如果mid的值大于target，则target会在左侧，或在被旋转的部分
                        if (nums[mid] > target) {
                            // 如果右侧小于target则不会在旋转部分
                            if (nums[r] < target) {
                                r = mid - 1;
                            } else {
                                l = mid + 1;
                            }
                        } else {
                            // 否则target在右侧
                            l = mid + 1;
                        }
                    }else {
                        // 如果mid在旋转部分
                        // 如果mid值小于target，则会在升序部分或右侧
                        if (nums[mid] < target){
                            // 不会在旋转部分
                            if (nums[r] < target){
                                r = mid - 1;
                            }else {
                                l = mid + 1;
                            }
                        }else {
                            r = mid - 1;
                        }
                    }
                }else {
                    // 未旋转的数组
                    if (nums[mid] > target){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}