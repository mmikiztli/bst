package com.codecool.javabst;

import java.util.*;

/**
 * Created by marti on 2017.06.26..
 */
public class TreeNode {

    private Integer data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }


    public void addNode(Integer number) {
        if (this.data.equals(number)) {
            System.out.println("Number is already in tree");
        } else if (number < this.data) {
            if (this.left != null) {
                this.left.addNode(number);
            } else {
                this.left = new TreeNode(number);
            }
        } else {
            if (this.right != null) {
                this.right.addNode(number);
            } else {
                this.right = new TreeNode(number);
            }
        }
    }

    private void getNodesList(List<Integer> nodeList, TreeNode node) {
        List<Integer> currentNodes = nodeList;
        if (node.left != null && node.right != null) {
            nodeList.add(node.left.data);
            nodeList.add(node.right.data);
            getNodesList(currentNodes, node.left);
            getNodesList(currentNodes, node.right);
        } else if (node.left != null) {
            nodeList.add(node.left.data);
            getNodesList(currentNodes, node.left);
        } else if (node.right != null) {
            nodeList.add(node.right.data);
            getNodesList(currentNodes, node.right);
        }
    }

    private TreeNode findNode(TreeNode node, Integer number) {
        TreeNode parent = this.parent;
        while (!node.data.equals(number)) {
            parent = node;
            if (number < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        node.parent = parent;
        return node;
    }

    private void deleteNode(TreeNode parent, TreeNode node) {
        if (parent.left.equals(node)) {
            parent.left = null;
            node.right = null;
            node.left = null;
        } else {
            parent.right = null;
            node.right = null;
            node.left = null;
        }
    }

    public void removeNode(Integer number) {
        TreeNode node = findNode(this, number);
        List<Integer> nodeList = new ArrayList<>();
        getNodesList(nodeList, node);
        deleteNode(node.parent, node);
        for (Integer element : nodeList) {
            addNode(element);
        }
    }

    public boolean searchNode(Integer number) {
        if (this.data.equals(number)) {
            return true;
        } else if (this.data > number) {
            if (this.left != null) {
                return left.searchNode(number);
            }
        } else {
            if (this.right != null) {
                return this.right.searchNode(number);
            }
        }
        return false;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                data +
                '}';
    }

}