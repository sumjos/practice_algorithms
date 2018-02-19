package com.company.searches;

public class BinarySearchTree {
    BinarySearchTree left;
    BinarySearchTree right;
    int val;

    public BinarySearchTree(int val, BinarySearchTree left, BinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void deleteNode(int val, BinarySearchTree parent) {
        if(val > this.val && this.right != null) {
            this.right.deleteNode(val, this);
        } else if(val < this.val && this.left != null) {
            this.left.deleteNode(val, this);
        }
        else if(val == this.val) {
            if(this.left == null && this.right == null) {
                if(this == parent.left) {
                    parent.left = null;
                } else if(this == parent.right) {
                    parent.right = null;
                }
            } else if(this.left != null && this.right == null) {
                if(this == parent.left) {
                    parent.left = this.left;
                } else if(this == parent.right) {
                    parent.right = this.left;
                }
            } else if(this.right != null && this.left == null) {
                if(this == parent.left) {
                    parent.left = this.right;
                } else if(this == parent.right) {
                    parent.right = this.right;
                }
            } else {
                this.val = this.right.findMinimum().val;
                this.right.deleteNode(this.val, this);
            }
        }
    }

    public BinarySearchTree findMinimum() {
        if(this.left == null) {
            return this;
        }
        return this.left.findMinimum();
    }


    public static void main(String [] args) {
        BinarySearchTree head = new BinarySearchTree(10, null, null);
        head.right = new BinarySearchTree(15, null, null);
        head.left = new BinarySearchTree(5, null, null);
        head.right.left = new BinarySearchTree(13, null, null);
        head.right.right = new BinarySearchTree(17, null, null);
        head.left.left = new BinarySearchTree(2, null, null);
        head.left.right = new BinarySearchTree(7, null, null);

        //head.deleteNode(0, head);
        head.deleteNode(2, head);
        //head.deleteNode(5, head);
        //head.deleteNode(15, head);
        int t = 5;
    }
}

