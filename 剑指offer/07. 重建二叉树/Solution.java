//题目：
//        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

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
    private Map<Integer, Integer> indexMap = new HashMap<>();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int preorder_index, int inorder_left, int inorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_index]);
        int index = indexMap.get(preorder[preorder_index]);

        root.left = buildTree(preorder_index + 1, inorder_left, index - 1);
        root.right = buildTree(preorder_index + index - inorder_left + 1, index + 1, inorder_right);
        return root;
    }
}
