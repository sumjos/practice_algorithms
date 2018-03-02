package com.company.algorithms;

public class MaxPallindromeSubstring {


    public static void main(String []args) {
        MaxPallindromeSubstring mp = new MaxPallindromeSubstring();
        String st1 = "babab";
        System.out.println(mp.longestPalindrome(st1));
    }

    public String longestPalindrome(String s) {
        //boolean b[][][] = new boolean[s.length()][s.length()][2];
        boolean b[] = new boolean[s.length()*s.length()*2];
        int max = 0;
        int lid = 0;
        int mid = 0;
        for(int x = 0; x < s.length(); x++) {
            for(int y = x; y < s.length(); y++) {
                if(isPallindrome(s, b, x, y)) {
                    if(mid - lid < y - x) {
                        mid = y;
                        lid = x;
                    }
                }
            }
        }
        return s.substring(lid, mid+1);
    }

    public boolean isPallindrome(final String s, boolean b[], int x, int y) {
        int dim = s.length();
        int idx_sol = (x*dim + y)*2;
        int idx_isDef = (x*dim + y)*2 + 1;
        if(b[idx_isDef]) {
            return b[idx_sol];
        } else if(x == y) {
            b[idx_sol + 1] = true;
            b[idx_sol] = true;
            return b[idx_sol];
        } else if(y - x == 1) {
            b[idx_sol + 1] = true;
            b[idx_sol] = s.charAt(x) == s.charAt(y);
            return b[idx_sol];
        } else {
            b[idx_sol + 1]  = true;
            b[idx_sol] = (s.charAt(x) == s.charAt(y)) && isPallindrome(s, b, x+1, y-1);
            return b[idx_sol];
        }
    }
}