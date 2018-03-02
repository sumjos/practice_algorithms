package com.company.algorithms;

public class MaxSubArray {
    public static void main(String []args) {
        int arr[] = {-2, -3, 400, -400, 2, 2, 5, -3};
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

            /*if(maxSubSeqSum < 0 && a[i] > maxSubSeqSum) {
                maxSubSeqSum = a[i];
            } else if(maxSubSeqSum >= 0 && a[i] > 0) {
                maxSubSeqSum += a[i];
            }*/
        }
        return max_so_far;
    }

}
