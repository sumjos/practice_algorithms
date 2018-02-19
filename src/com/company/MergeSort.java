package com.company;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Iterator;

public class MergeSort {
    public void doSort(int arr[], int start, int end) {
        if(start < end) {
            int mid = (int)Math.floor((start + end)/2);
            doSort(arr, start, mid);
            doSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    public void merge(int arr[], int start, int mid, int end) {
        int arrLeft[] = new int[mid - start + 1];
        int arrRight[] = new int[end - mid];
        for(int x = 0; x < arrLeft.length; x++) {
            arrLeft[x] = arr[start + x];
        }
        for(int x = 0; x < arrRight.length; x++) {
            arrRight[x] = arr[mid + 1 + x];
        }
        int leftIdx = 0, rightIdx = 0;
        int count = start;
        while(leftIdx < arrLeft.length && rightIdx < arrRight.length) {
            if(arrLeft[leftIdx] < arrRight[rightIdx]) {
                arr[count] = arrLeft[leftIdx];
                count+=1;
                leftIdx+=1;
            } else {
                arr[count] = arrRight[rightIdx];
                count+=1;
                rightIdx+=1;
            }
        }
        if (leftIdx == arrLeft.length) {
            while(rightIdx < arrRight.length) {
                arr[count] = arrRight[rightIdx];
                count+=1;
                rightIdx+=1;
            }
        } else if (rightIdx ==  arrRight.length) {
            while(leftIdx < arrLeft.length) {
                arr[count] = arrLeft[leftIdx];
                count+=1;
                leftIdx+=1;
            }
        }
    }

    public  static void main(String [] args) {
        int arr[] = {10,9, 45, 34, 1,2,3,4,5,99,0, 1,2,4,3,2,1};
        new MergeSort().doSort(arr, 0, arr.length - 1);
        for(int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
    }
}
