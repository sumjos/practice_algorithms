package com.company.algorithms;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node n = new Node(8, null, null);
        n.left = new Node(4, null, null);
        n.right = new Node(9, null, null);
        n.left.left = new Node(1, null, new Node(2, null, new Node(3, null, null)));
        n.left.right = new Node(6, new Node(5, null, null), null);
        Node lca = Node.lca(n, 1, 2);
        int temp = 2;
    }
}

class Node {

    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static Node lca(Node root,int v1, int v2)
    {
        return Node.getLca(root, root, v1, v2);

    }

    static Node getLca(Node node, Node parent, int v1, int v2) {
        if (node.data > v1 && node.data > v2) {
            return Node.getLca(node.left, node, v1, v2);
        } else if (node.data < v1 && node.data < v2) {
            return Node.getLca(node.right, node, v1, v2);
        } else if (node.data == v1 || node.data == v2){
            return node;
        } else {
            return null;
        }
        /*if (node == null) {
            return parent;
        } else if (node.data > v1 && node.data > v2) {
            return Node.getLca(node.left, node, v1, v2);
        } else if (node.data < v1 && node.data < v2) {
            return Node.getLca(node.right, node, v1, v2);
        } else if (node.data == v1 || node.data == v2){
            return node;
        } else {
            return parent;
        }*/
    }
}
