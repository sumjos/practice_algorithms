package com.company.misc;

import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> ls = new ArrayList<Integer>();
        int len;
        while(count > 0 ) {
            addNumToSortedList(ls, sc.nextInt());
            len = ls.size();
            System.out.printf("%.1f\n", (len % 2 == 1) ? (float)ls.get((len + 1)/2 -1) : (ls.get(len/2 -1) + (float)ls.get(len/2))/2);
            count--;
        }
    }

    public static void addNumToSortedList(List<Integer> ls, int num) {
        int idx = 0;
        int lastIdx = ls.size() - 1;
        if (lastIdx < 0) {
            ls.add(num);
            return;
        }
        while(idx <= lastIdx) {
            if (ls.get(idx) >= num) {
                ls.add(idx, num);
                return;
            }
            idx++;
        }
        ls.add(idx, num);
    }
}

