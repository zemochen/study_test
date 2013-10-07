package com.zemo.test.tree;

import java.util.Stack;

/**
 * 
 * @file BinaryTree
 * @author zemo
 * @mail zemochen@gmail.com
 * @data 2013年10月3日 上午12:41:01
 * @description: 二叉树的链式储存
 */
public class BinaryTree {
	private TreeNode root = null;

	public BinaryTree() {
		root = new TreeNode(1, "rootNode(A)");
	}

	/**
	 * 
	 * @Title: createBinTree
	 * @Description: 创建一颗二叉树 A B C D E F
	 * @param @param root
	 * @return void
	 * @throws
	 */
	public void createBinTree(TreeNode root) {
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(6, "F");
		root.leftChild = newNodeB;
		root.rightChild = newNodeC;
		root.leftChild.leftChild = newNodeD;
		root.leftChild.rightChild = newNodeE;
		root.rightChild.rightChild = newNodeF;
	}

	public boolean isEmpty() {
		return root == null;
	}

	// 树高度
	public int height() {
		return height(root);
	}

	// 节点个数
	public int size() {
		return size(root);
	}

	// 返回双亲节点
	public TreeNode parent(TreeNode element) {
		return (root == null || root == element) ? null : parent(root, element);
	}

	private TreeNode parent(TreeNode subTree, TreeNode element) {
		if (subTree == null) {
			return null;
		}
		if (subTree.leftChild == element || subTree.rightChild == element) {
			// 返回父节点地址
			return subTree;
		}
		// 在左子树中找，如果左字数中没有找到，才到右子树中找
		if (parent(subTree.leftChild, element) != null) {
			// 递归在左子树中搜索
			return parent(subTree.leftChild, element);
		} else {
			// 递归在右子树中搜索
			return parent(subTree.rightChild, element);
		}
	}

	public TreeNode getLeftChildNode(TreeNode element) {
		return (element == null) ? null : element.leftChild;
	}

	public TreeNode getRightChildNode(TreeNode element) {
		return (element == null) ? null : element.rightChild;
	}

	public TreeNode getRoot() {
		return root;
	}

	// 在释放某个结点时，该节点的左右子树都已经释放
	// 所以应该采用后续遍历，当访问某个节点时将该节点的存储空间释放
	public void destroy(TreeNode subTree) {
		// 删除根为subTree的子树
		if (subTree != null) {
			destroy(subTree.leftChild);
			destroy(subTree.rightChild);
			// 删除根节点
			subTree = null;
		}
	}

	public void traverse(TreeNode subTree) {
		System.out.println("traverse->key:" + subTree.key + "--name:"
				+ subTree.data);
		traverse(subTree.leftChild);
		traverse(subTree.rightChild);
	}

	// 前序遍历
	public void preOrder(TreeNode subTree) {
		if (subTree != null) {
			visited(subTree);
			preOrder(subTree.leftChild);
			preOrder(subTree.rightChild);
		}
	}

	// 中序遍历
	public void inOrder(TreeNode subTree) {
		if (subTree != null) {
			inOrder(subTree.leftChild);
			visited(subTree);
			inOrder(subTree.rightChild);
		}
	}

	// 后序遍历
	public void postOrder(TreeNode subTree) {
		if (subTree != null) {
			postOrder(subTree.leftChild);
			postOrder(subTree.rightChild);
			visited(subTree);
		}
	}

	// 前序遍历的非递归实现
	public void nonRecPreOrder(TreeNode subTree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = subTree;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				visited(node);
				stack.push(node);
				node = node.leftChild;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.rightChild;
			}
		}
	}

	// 中序遍历的非递归实现
	public void nonRecInOrder(TreeNode subTree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = subTree;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.leftChild;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visited(node);
				node = node.rightChild;
			}
		}
	}

	// 后序遍历的非递归实现
	public void nonRecPostOrder(TreeNode subTree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = subTree;
		while (node != null) {
			for (; subTree.leftChild != null; subTree = subTree.leftChild) {
				stack.push(subTree);
			}

			while (node != null
					&& (subTree.rightChild == null || subTree.rightChild == node)) {
				visited(subTree);
				node = subTree;
				if (stack.empty()) {
					return;
				}
				subTree = stack.pop();
			}
			stack.push(subTree);
			subTree = subTree.rightChild;
		}
	}

	private void visited(TreeNode subTree) {
		subTree.isVisted = true;
		System.out.println("visited->key:" + subTree.key + "--name:"
				+ subTree.data);
	}

	private int size(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		} else {
			return 1 + size(subTree.leftChild) + size(subTree.rightChild);
		}
	}

	private int height(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		} else {
			int i = height(subTree.leftChild);
			int j = height(subTree.rightChild);
			return (i < j ? (j + 1) : (i + 1));
		}
	}
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.createBinTree(bt.root);
		System.out.println("the size of the tree is: "+bt.size());
		System.out.println("the height of the tree is: "+bt.height());
		System.out.println("-------------------(前序遍历)【ABDECF】遍历-----------------");
		bt.preOrder(bt.root);
		System.out.println("-------------------(中序遍历)【DBEACF】遍历-----------------");
		bt.inOrder(bt.root);
		System.out.println("-------------------(后序遍历)【DEBFCA】遍历-----------------");
		bt.postOrder(bt.root);
		System.out.println("----------非递归实现---------(前序遍历)【ABDECF】遍历-----------------");
		bt.nonRecPreOrder(bt.root);
		System.out.println("----------非递归实现---------(前序遍历)【DBEACF】遍历-----------------");
		bt.nonRecInOrder(bt.root);
		System.out.println("----------非递归实现---------(前序遍历)【DEBFCA】遍历-----------------");
		bt.nonRecPostOrder(bt.root);
		
	}

}
