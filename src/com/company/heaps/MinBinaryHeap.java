package com.company.heaps;

public class MinBinaryHeap {

    private int harr[];
    private int hSize;
    private final int MAX_HEAP_SIZE;

    public MinBinaryHeap(final int size) {
        MAX_HEAP_SIZE = size;
        harr = new int[MAX_HEAP_SIZE];
        hSize = 0;
    }

    public int[] getBaseArr() {
        return harr;
    }

    public boolean insert(final int val) {
        if (hSize == MAX_HEAP_SIZE) {
            System.out.println("Heap is full!");
            return false;
        } else {
            harr[hSize] = val;
            hSize ++;
            int idx = hSize - 1;
            int par;
            while (idx > 0 && harr[par = getParent(idx)] > harr[idx] ) {
                int temp = harr[idx];
                harr[idx] = harr[par];
                harr[par] = temp;
                idx = par;
            }
            return true;
        }
    }

    public boolean deleteKey(final int k) {
        if (k >= hSize) {
            return false;
        } else {
            decreaseKey(k, Integer.MIN_VALUE);
            extractMin();
            return true;
        }
    }

    /*Assumes val to be inserted is smaller than the previous value*/
    public boolean decreaseKey(final int k, final int val) {
        if (k >= hSize || val >= harr[k]) {
            return false;
        } else {
            harr[k] = val;
            int idx = k;
            int par;
            while (idx > 0 && harr[par = getParent(idx)] > harr[idx] ) {
                int temp = harr[idx];
                harr[idx] = harr[par];
                harr[par] = temp;
                idx = par;
            }
            return true;
        }
    }

    public int extractMin() {
        if (hSize == 0) {
            return Integer.MAX_VALUE;
        } else {
            int val = harr[0];
            harr[0] = harr[hSize - 1];
            hSize--;
            minHeapify(0);
            return val;
        }
    }

    private int getParent(int k) {
        return (k-1)/2 >= 0 ? (k-1)/2 : 0;
    }

    private int getLeftChildId(int k) {
        return 2*k + 1;
    }

    private int getRightChildId(int k) {
        return 2*k + 2;
    }

    private void minHeapify(final int k) {
        if (k < 0 || k >= hSize) {
            return;
        }
        int smallest = k;
        if (getLeftChildId(k) < hSize && harr[getLeftChildId(k)] < harr[smallest]) {
            smallest = getLeftChildId(k);
        } if(getRightChildId(k) < hSize && harr[getRightChildId(k)] < harr[smallest]) {
            smallest = getRightChildId(k);
        } if(smallest != k) {
            int temp = harr[smallest];
            harr[smallest] = harr[k];
            harr[k] = temp;
            minHeapify(smallest);
        }
    }
}
