package com.company.misc;

import java.util.*;

public class TesterClass {

    public static void main(String [] args) {

        int arr[] = {1,3,5,6};
        int k = 7;
        //System.out.println(searchInsert(arr, k));
        //int grid[][] = {{1,3,1}, {1,5,1}, {4,2,1}};
        int grid[][] = {{1,3,1}, {1,1,5}};
        System.out.println(findPathCost(grid, 0, 0));
    }

    public static int findPathCost(int grid[][], int i, int j) {
        int cost = grid[i][j];
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return cost;
        } if(i == grid.length - 1) {
            return cost + findPathCost(grid, i, j+1);
        } if(j == grid[0].length - 1) {
            return cost + findPathCost(grid, i+1, j);
        }
        return cost + Math.min(findPathCost(grid, i+1, j), findPathCost(grid, i, j+1));
    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end + 1;

    }


}