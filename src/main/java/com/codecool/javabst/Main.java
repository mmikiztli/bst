package com.codecool.javabst;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }

        TreeNode myTree = BinarySearchTree.build(numbers);

        // write some test code here
        System.out.println(myTree.searchNode(7)); // should be true
        System.out.println(myTree.searchNode(55)); // should be true
        System.out.println(myTree.searchNode(34535)); // should be false


        System.out.println("done");
        //System.out.println(numbers);

        myTree.addNode(8);
        myTree.addNode(14);
        myTree.removeNode(9);

    }
}