//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// 👍 1054 👎 0

package com.kuer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kuer
 * 2023-03-05 23:07:28
 */
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            return leetCode(board);
        }

        /**
         * 使用数组代替HashMap
         * @param board
         * @return
         */
        private boolean leetCode(char[][] board){
            // rowData[i]表示第i行数据
            boolean[][] rowData = new boolean[9][9];
            // columnData[i]表示第i列数据
            boolean[][] columnData = new boolean[9][9];
            // regionData[i][j]表示 i行j列九宫格
            boolean[][][] regionData = new boolean[3][3][9];
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                char[] currentRowData = board[rowIndex];
                for (int columnIndex = 0; columnIndex < currentRowData.length; columnIndex++) {
                    char currentData = currentRowData[columnIndex];
                    if ('.' == currentData){
                        continue;
                    }
                    if (rowData[rowIndex][currentData - '1']){
                        return false;
                    }else {
                        rowData[rowIndex][currentData - '1'] = true;
                    }

                    if (columnData[columnIndex][currentData - '1']){
                        return false;
                    }else {
                        columnData[columnIndex][currentData - '1'] = true;
                    }

                    if (regionData[rowIndex / 3][columnIndex / 3][currentData - '1']){
                        return false;
                    }else {
                        regionData[rowIndex / 3][columnIndex / 3][currentData - '1'] = true;
                    }
                }
            }
            return true;
        }

        private boolean myMethod(char[][] board) {
            Map<Integer, Map<Character, Character>> rowMap = new HashMap<>(16);
            Map<Integer, Map<Character, Character>> columnMap = new HashMap<>(16);
            // 00, 01, 02
            // 10, 11, 12
            // 20, 21, 22
            Map<String, Map<Character, Character>> regionMap = new HashMap<>(16);
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                char[] rowData = board[rowIndex];
                Map<Character, Character> currentRow = getCurrentData(rowMap, rowIndex);
                for (int columnIndex = 0; columnIndex < rowData.length; columnIndex++) {
                    String regionIndex = rowIndex / 3 + String.valueOf(columnIndex / 3);
                    Map<Character, Character> currentRegion = getCurrentData(regionMap, regionIndex);
                    char data = rowData[columnIndex];
                    Map<Character, Character> currentColumn = getCurrentData(columnMap, columnIndex);
                    // 如果是空跳过
                    if ('.' == data) {
                        continue;
                    }
                    if (judgmentValidity(currentRow, data)) {
                        return false;
                    }
                    if (judgmentValidity(currentColumn, data)) {
                        return false;
                    }
                    if (judgmentValidity(currentRegion, data)) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * 获取对应当前的数据
         *
         * @param regionMap
         * @param regionIndex
         * @return
         */
        private <T> Map<Character, Character> getCurrentData(Map<T, Map<Character, Character>> regionMap, T regionIndex) {
            Map<Character, Character> currentRegion;
            if (regionMap.containsKey(regionIndex)) {
                currentRegion = regionMap.get(regionIndex);
            } else {
                currentRegion = new HashMap<>(16);
                regionMap.put(regionIndex, currentRegion);
            }
            return currentRegion;
        }

        /**
         * 判断是否合法
         *
         * @param currentRow
         * @param data
         * @return
         */
        private boolean judgmentValidity(Map<Character, Character> currentRow, char data) {
            if (currentRow.containsKey(data)) {
                return true;
            } else {
                currentRow.put(data, data);
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}