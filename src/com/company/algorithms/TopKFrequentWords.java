package com.company.algorithms;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String []args) {
        TopKFrequentWords tk = new TopKFrequentWords();
        String arr[] = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        Iterator<String> itr = tk.topKFrequent(arr, k).iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> mp = new HashMap<String, Integer>();
        for(int idx = 0; idx < words.length; idx ++) {
            if(mp.get(words[idx]) == null) {
                mp.put(words[idx], 1);
            } else {
                mp.put(words[idx], mp.get(words[idx]) + 1);
            }
        }

        //1 indexed array
        List<String>[] arr = new ArrayList[words.length+1];
        for(Map.Entry<String, Integer> ent : mp.entrySet()) {
            if(arr[ent.getValue()] == null) {
                arr[ent.getValue()] = new ArrayList<String>();
                arr[ent.getValue()].add(ent.getKey());
            } else {
                arr[ent.getValue()].add(ent.getKey());
            }
        }

        int count = k;
        List<String> soln = new ArrayList<String>();
        for(int x = words.length; x > 0 && count > 0; x--) {
            if(arr[x] != null) {
                getKSortedWords(arr[x], count);
                int temp = count > arr[x].size() ? arr[x].size() : count;
                soln.addAll(arr[x].subList(0, temp));
                count -= arr[x].size();
            }
        }
        return soln;
    }

    private void getKSortedWords(List<String> ls, int k) {
        Collections.sort(ls);
    }
}
