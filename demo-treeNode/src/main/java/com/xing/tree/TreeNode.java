package com.xing.tree;

/**
 * @author: Xingweicheng
 * @description: 二叉树定义
 * @date: 2022/11/24 21:23
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int val,TreeNode left,TreeNode right ){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public TreeNode(int val){
        this.val=val;
    }
}
