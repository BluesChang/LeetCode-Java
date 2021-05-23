//题目：输入两颗二叉树A和B，判断B是不是A的子结构。
//       1                3
//      / \              /
//A = 2   3      B =  4
//        /
//       4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (doesTree1HaveTree2(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean doesTree1HaveTree2(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return doesTree1HaveTree2(A.left, B.left) && doesTree1HaveTree2(A.right, B.right);
    }
}