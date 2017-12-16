package com.company.linkedLists;

public class CustomLinkedList<T> {
    Node<T> listHead;

    public CustomLinkedList() {
        this.listHead = null;
    }

    public CustomLinkedList(Node n) {
        this.listHead = n;
    }

    public void addNode(Node node, boolean addToStart) {
        if (addToStart) {
            node.next = this.listHead;
            this.listHead = node;
        } else {
            if (this.listHead == null) {
                this.listHead = node;
            } else {
                this.addNodeToLast(node, this.listHead);
            }
        }
    }

    public T popNode(boolean firstNode) {
        T value;
        if (this.listHead == null) {
            return null;
        } else if (firstNode) {
            value = this.listHead.value;
            this.listHead = this.listHead.next;
            return value;
        } else {
            if (this.listHead.next == null) {
                value = this.listHead.value;
                this.listHead = null;
                return value;
            } else {
                return getLastNode(this.listHead);
            }
        }
    }

    public void printList() {
        this.printListElements(this.listHead);
    }

    public void reverseNodeList() {
        if (this.listHead != null) {
            this.listHead = reverseList(this.listHead);
        }
    }


    private void addNodeToLast(Node node, Node head) {
        if (head.next == null) {
            head.next = node;
        } else {
            addNodeToLast(node, head.next);
        }
    }

    private T getLastNode(Node<T> head) {
        if (head.next.next == null) {
            T val = head.next.value;
            head.next = null;
            return val;
        } else {
            return getLastNode(head.next);
        }
    }

    private void printListElements(Node n) {
        if (n != null) {
            System.out.println(String.valueOf(n.value));
            printListElements(n.next);
        }
    }

    private Node reverseList(Node currNode) {
        if (currNode.next == null) {
            return currNode;
        } else {
            Node t = reverseList(currNode.next);
            currNode.next.next = currNode;
            currNode.next = null;
            return t;
        }
    }
}
