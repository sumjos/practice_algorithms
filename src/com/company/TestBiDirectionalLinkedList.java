package com.company;

import com.company.linkedLists.CustomLinkedList;
import com.company.linkedLists.Node;

public class TestBiDirectionalLinkedList {
    public static void main(String[] args) {

        //Example of a bi-directional linked list
        CustomLinkedList list = new CustomLinkedList<Integer>();
        list.addNode(new Node(1, null), false);
        list.addNode(new Node(2, null), false);
        list.addNode(new Node(3, null), true);

        System.out.println("Current list is:");
        list.printList();

        System.out.print("Node popped from the end is:\t");
        System.out.println(String.valueOf(list.popNode(false)));

        System.out.print("Node popped from the start is:\t");
        System.out.println(String.valueOf(list.popNode(true)));

        //Reinitializing list for other tests
        System.out.println("Adding more nodes for list reversal test:\t");
        list.addNode(new Node(4, null), false);
        list.addNode(new Node(5, null), false);
        System.out.println("Current state of list after filling more elements:");
        list.printList();

        //Reversing list
        list.reverseNodeList();
        System.out.println("List post reversal:");
        list.printList();
    }
}
