package com.company.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortCharByFreq {
    public String frequencySort(String s) {

        Map<Character, Obj> mp = new HashMap<Character, Obj>();

        for(int x = 0; x< s.length(); x++) {
            char ch = s.charAt(x);
            if (mp.containsKey(ch)) {
                Obj t = mp.get(ch);
                t.addChar();
                mp.put(ch, t);
            } else {
                Obj t = new Obj(String.valueOf(ch));
                mp.put(ch, t);
            }
        }

        String soln = "";

        String [] ls = new String[s.length() + 1];

        for(Map.Entry<Character, Obj> ent : mp.entrySet()) {
            ls[ent.getValue().occur] = (ls[ent.getValue().occur] == null) ? ent.getValue().val : ls[ent.getValue().occur] + ent.getValue().val;
        }

        for(int x = s.length(); x > 0; x--) {
            if(ls[x] != null && ls[x].length() != 0) {
                soln = soln.concat(ls[x]);
            }
        }

        return soln;
    }
}

class Obj {
    int occur = 0;
    String ch = "";
    String val = "";
    Obj(String c) {
        occur = 1;
        ch = c;
        val = val.concat(c);
    }

    void addChar() {
        val = val.concat(ch);
        occur ++;
    }
}
