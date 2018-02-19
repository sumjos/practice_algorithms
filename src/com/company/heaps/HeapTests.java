package com.company.heaps;

public class HeapTests {

    public static void main(String [] args) {
        MinBinaryHeap mbh = new MinBinaryHeap(10);
        mbh.insert(10);
        mbh.insert(2);
        mbh.insert(1);
        mbh.insert(5);
        mbh.insert(4);
        mbh.insert(1);
        mbh.insert(3);
        int arr[] = mbh.getBaseArr();
        int idx = 0;
        /*Expected: 1,4,1,10,5,2,3,0,0,0*/
        while(idx < arr.length) {
            System.out.println(arr[idx]);
            idx++;
        }

        /*Expected: 1,1,2,3*/
        System.out.println(mbh.extractMin());
        System.out.println(mbh.extractMin());
        System.out.println(mbh.extractMin());
        System.out.println(mbh.extractMin());


    }
}
