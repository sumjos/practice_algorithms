package com.company.misc;

import java.util.Stack;

public class ValidExpressionBrackets {

    public static void main(String args[]) {
        String testStr = "[{([()])}]";
        System.out.println(isValidExpr(testStr) ? "Valid" : "Invalid");
        System.out.println("ab" == "nab");
    }

    private static boolean isValidExpr(String str) {

        Stack <Character> st = new Stack<Character>();
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else if( ch == '}' || ch == ']' || ch ==')') {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char brack = st.pop();
                    if((ch == ']' && brack != '[') || (ch == '}' && brack != '{') || (ch == ')' && brack != '(')) {
                        return false;
                    }
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
