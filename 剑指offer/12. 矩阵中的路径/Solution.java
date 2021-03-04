// 题目：
//        请设计一个函数，用来判断在一个矩阵中是否存在一条包含其字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
//        每一步可以在矩阵中向左、右、上、下移动一格，如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
//        例如，在下面的3x4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，
//        因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || words[k] != board[i][j]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = ' ';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}