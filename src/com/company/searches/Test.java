package com.company.searches;

public class Test {
    public static void main(String []args) {

        String s = "abc";
        String []str = {"0 0 L", "1 2 R", "0 2 R"};
        int arr[] = new int[3];
        int li, ri, op;
        String temp[] = new String[3];
        for(int x = 0; x<str.length; x++) {
            temp = str[x].split("\\s+");
            li = Integer.parseInt(temp[0].trim());
            ri = Integer.parseInt(temp[1].trim());
            op = temp[2].trim().equalsIgnoreCase("L") ? -1 : 1;
            String t = "";
            for(int y=0; y<s.length(); y++) {
                char ch = s.charAt(y);
                if(y>=li && y<=ri) {
                    ch+=op;
                    if(ch > 122) {
                        ch = 97;
                    } else if(ch < 97) {
                        ch = 122;
                    }
                }
                t = t.concat(String.valueOf(ch));
            }
            s = t;
        }
        System.out.println(s);
    }
}
