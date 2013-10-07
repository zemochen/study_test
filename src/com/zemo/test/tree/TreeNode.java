package com.zemo.test.tree;

public class TreeNode {
	public int key = 0;
	public String data = null;
	public TreeNode leftChild = null;
	public TreeNode rightChild = null;
	public boolean isVisted = false;
	public TreeNode(){}
	public TreeNode(int key, String data) {
		this.key = key;
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}
