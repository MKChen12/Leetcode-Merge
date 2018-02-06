package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeInorderTraversal
 * Creator : Edward
 * Description : 144. Binary Tree Preorder Traversal
 */
public class _94_Binary_Tree_Inorder_Traversal {
	/**
      Given a binary tree, return the inorder traversal of its nodes' values.
      
      题意： 
      	实现二叉树的中序遍历
     

     思路：
     	递归与非递归（迭代）
     
     复杂度：      
      time : O(n)
      space : O(n)
      @param root
      @return
     */

    public static List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       if (root == null) return res;
       helper(res, root);
       return res;
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}