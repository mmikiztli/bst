package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    public static TreeNode build(List<Integer> elements) {
        if(elements.size()==0){
            return null;
        }
        int middle = elements.size() / 2;
        TreeNode node = new TreeNode(elements.get(middle));
        node.setLeft(build(elements.subList(0,middle)));
        node.setRight(build(elements.subList(middle+1,elements.size())));
        return node;
    }
}