package com.company.algorithms;

public class MedianOfSortedArrays {


    public static void main(String [] args) {
        int a1[] = {5};
        int a2[] = {1, 2,3,4,6, 7};
        System.out.println(MedianOfSortedArrays.getMedian(a1, a2));

    }

    static double getMedian(int arr1[], int arr2[]) {
        int start = 0;
        int end = arr1.length - 1;

        int l1 = arr1.length;
        int l2 = arr2.length;
        int medianIdx = (l1 + l2 - 1)/2;  //when l1+l2 is odd

        while(start <= end) {
            int mid = (start + end)/2;
            int remEl = medianIdx - mid;
            //median in odd case
            if(remEl < 0) {
                end = mid  - 1;
            } else if(remEl == 0 && l2!= 0 && arr2[0] < arr1[mid]) {
                end = mid - 1;
            } else if(remEl == 0) {
                if ((l1 + l2)%2 == 1) {
                    return arr1[mid];
                } else {
                    if(mid < l1 - 1 && (l2 == remEl || arr1[mid + 1] <= arr2[remEl])) {
                        return (double) (arr1[mid] + arr1[mid + 1])/2;
                    } else {
                        return (double) (arr1[mid] + arr2[remEl])/2;
                    }
                }
            }
            else if (((l2 > remEl && arr2[remEl] >= arr1[mid]) || l2 == remEl) && arr2[remEl - 1] <= arr1[mid]) {
                if ((l1 + l2)%2 == 1) {
                    return arr1[mid];
                } else {
                    if(mid < l1 - 1 && (l2 == remEl || arr1[mid + 1] <= arr2[remEl])) {
                        return (double) (arr1[mid] + arr1[mid + 1])/2;
                    } else {
                        return (double) (arr1[mid] + arr2[remEl])/2;
                    }
                }
            } else if(remEl > l2 || arr2[remEl-1] > arr1[mid]) {
                start = mid + 1;
            } else if(l2 == remEl || arr2[remEl] < arr1[mid]) {
                end = mid - 1;
            }
        }

        //does not exist in first array
        start = 0; end = arr2.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            int remEl = medianIdx - mid;
            //median in odd case
            if(remEl < 0) {
                end = mid - 1;
            } else if(remEl == 0 && l1!= 0 && arr1[0] < arr2[mid]) {
                end = mid - 1;
            } else if(remEl == 0) {
                if ((l1 + l2)%2 == 1) {
                    return arr2[mid];
                } else {
                    if(mid < l2 - 1 && (remEl == l1 || arr2[mid + 1] <= arr1[remEl])) {
                        return (double) (arr2[mid] + arr2[mid + 1])/2;
                    } else {
                        return (double) (arr2[mid] + arr1[remEl])/2;
                    }
                }
            }
            else if (((l1 > remEl && arr1[remEl] >= arr2[mid]) || l1 == remEl) && arr1[remEl - 1] <= arr2[mid]) {
                if ((l1 + l2)%2 == 1) {
                    return arr2[mid];
                } else {
                    if(mid < l2 - 1 && (remEl == l1 || arr2[mid + 1] <= arr1[remEl])) {
                        return (double) (arr2[mid] + arr2[mid + 1])/2;
                    } else {
                        return (double) (arr2[mid] + arr1[remEl])/2;
                    }
                }
            } else if(remEl > l1 || arr1[remEl-1] > arr2[mid]) {
                start = mid + 1;
            } else if(l1 == remEl || arr1[remEl] < arr2[mid]) {
                end = mid - 1;
            }
        }

        return 0;
    }
}
