package all.TreePackage;

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private TreeNode<T> root;

    @Override
    public T getRootData() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getNumberOfNodes() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return null;
    }

    public void iterativePreorderTraverse() {

    }

    public void iterativeInorderTraverse() {

    }

    // Inner class to represent the node of the tree
    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this(data, null, null);
        }

        public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Constructor for an empty tree
    public BinaryTree() {
        root = null;
    }

    // Constructor for a tree with just a root
    public BinaryTree(T rootData) {
        root = new TreeNode<>(rootData);
    }

    // Constructor for a tree with a root, left and right subtrees
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new TreeNode<>(rootData);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
    }

    @Override
    public void setRootData(T rootData) {
        if (root != null) {
            root.data = rootData;
        } else {
            root = new TreeNode<>(rootData);
        }
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        root = new TreeNode<>(rootData);
        if (leftTree != null) {
            this.root.left = ((BinaryTree<T>) leftTree).root;
        } else {
            this.root.left = null;
        }
        if (rightTree != null) {
            this.root.right = ((BinaryTree<T>) rightTree).root;
        } else {
            this.root.right = null;
        }
    }

    // Other methods from TreeInterface and TreeIteratorInterface can be added as needed
}
