//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4104 👎 0

package com.kuer.leetcode.editor.cn;
/**
 * @author kuer
 * 2023-02-23 15:45:00
 */
public class ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{1,1}));
        System.out.println(solution.maxArea(new int[]{1,3,2,5,25,24,5}));
        System.out.println(solution.maxArea(new int[]{1,2,3,4,5,25,24,3,4}));
        System.out.println(solution.maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        return doublePoint(height);
    }
    private int bruteForce(int[] heights){
        int max = 0;
        int width = 1;
        for (int left = 0; left + width < heights.length; left++) {
            while (left + width < heights.length){
                int area = Math.min(heights[left], heights[left + width]) * width;
                max = Math.max(max, area);
                width ++;
            }
            width = 1;
        }
        return max;
    }

    private int doublePoint (int[] height){
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}