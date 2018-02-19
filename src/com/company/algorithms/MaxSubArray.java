package com.company.algorithms;

public class MaxSubArray {
    public static void main(String []args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(MaxSubArray.findMaxSum(arr));
    }

    public static int findMaxSum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int maxSubSeqSum = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;

            if(maxSubSeqSum < 0 && a[i] > maxSubSeqSum) {
                maxSubSeqSum = a[i];
            } else if(maxSubSeqSum >= 0 && a[i] > 0) {
                maxSubSeqSum += a[i];
            }
        }
        return max_so_far;
    }
    /*public static long findMaxSum(int arr[]) {
        long maxSubSeqSum = arr[0];
        long finalSum = arr[0];
        long sum = arr[0], localMaxSum = arr[0];
        for(int x=1; x<arr.length; x++) {
            if(maxSubSeqSum < 0 && maxSubSeqSum < arr[x]) {
                maxSubSeqSum = arr[x];
            } else if(arr[x] > 0 && maxSubSeqSum < 0){
                maxSubSeqSum = arr[x];
            } else if(arr[x] > 0) {
                maxSubSeqSum += arr[x];
            }

            if (sum < sum + arr[x]) {
                if (sum <= 0) {
                    sum = arr[x];
                    localMaxSum = arr[x];
                    if (localMaxSum > finalSum) {
                        finalSum = localMaxSum;
                    }
                    continue;
                }
            } else if (sum > sum + arr[x]) {
                if (sum < arr[x]) {
                    sum = arr[x];
                    localMaxSum = arr[x];
                    if (localMaxSum > finalSum) {
                        finalSum = localMaxSum;
                    }
                    continue;
                }
                if (sum > localMaxSum) {
                    localMaxSum = sum;
                    if (localMaxSum > finalSum) {
                        finalSum = localMaxSum;
                    }
                }
            }
            sum+=arr[x];
        } if (sum > finalSum) {
            finalSum = sum;
        }
        return finalSum;
    }*/
}
