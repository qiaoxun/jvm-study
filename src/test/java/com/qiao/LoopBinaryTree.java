package com.qiao;

import java.util.Stack;

public class LoopBinaryTree {

    public static void main(String[] args) {
        LoopBinaryTree lbt = new LoopBinaryTree();
        BinaryTree bt = lbt.getBT();
        lbt.preorder(bt);
        System.out.println();
        lbt.inorder(bt);
        System.out.println();
        lbt.postOrder(bt);
    }

    /**
     * preorder Root, Left, Right
     * @param binaryTree
     */
    public void preorder(BinaryTree binaryTree) {
        if (binaryTree != null) {
            System.out.print(binaryTree.getValue());
        }

        if (null != binaryTree.getLeftChild()) {
            preorder(binaryTree.getLeftChild());
        }

        if (null != binaryTree.getRightChild()) {
            preorder(binaryTree.getRightChild());
        }
    }

    public void preorderStack(BinaryTree binaryTree) {
        Stack<BinaryTree> stack = new Stack<>();
        if (null != binaryTree) {
            stack.push(binaryTree);
        }
        System.out.println(stack.pop().getValue());

        if (null != binaryTree.getLeftChild()) {

        }
    }

    /**
     * Inorder (Left, Root, Right)
     * @param binaryTree
     */
    public void inorder(BinaryTree binaryTree) {
        if (null != binaryTree.getLeftChild()) {
            inorder(binaryTree.getLeftChild());
        }
        if (binaryTree != null) {
            System.out.print(binaryTree.getValue());
        }

        if (null != binaryTree.getRightChild()) {
            inorder(binaryTree.getRightChild());
        }
    }

    /**
     * Postorder (Left, Right, Root)
     * @param binaryTree
     */
    public void postOrder(BinaryTree binaryTree) {

        if (null != binaryTree.getLeftChild()) {
            postOrder(binaryTree.getLeftChild());
        }

        if (null != binaryTree.getRightChild()) {
            postOrder(binaryTree.getRightChild());
        }

        if (binaryTree != null) {
            System.out.print(binaryTree.getValue());
        }

    }


    public BinaryTree getBT() {
        BinaryTree root = new BinaryTree("A");
        BinaryTree left = new BinaryTree("B");
        BinaryTree leftL = new BinaryTree("D");
        BinaryTree leftR = new BinaryTree("E");
        BinaryTree right = new BinaryTree("C");
        BinaryTree rightL = new BinaryTree("F");
        BinaryTree rightR = new BinaryTree("G");

        right.setLeftChild(rightL);
        right.setRightChild(rightR);
        left.setLeftChild(leftL);
        left.setRightChild(leftR);
        root.setRightChild(right);
        root.setLeftChild(left);
        return root;
    }

}

class BinaryTree {
    private String value;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(String value) {
        this.value = value;
    }

    public BinaryTree(String value, BinaryTree leftChild, BinaryTree rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }
}