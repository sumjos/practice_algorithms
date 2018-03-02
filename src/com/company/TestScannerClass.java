package com.company;

import com.google.gson.JsonElement;

import java.util.*;

public class TestScannerClass {
    public static void main(String[] args) {
        //final Set<Map.Entry<String, JsonElement>> entrySet = queryElement.getAsJsonObject().entrySet();
        //return entrySet.parallelStream().allMatch(entry -> matches(entry.getValue(), bElObj.get(entry.getKey())));
        /*int arr1 []= {1,2 ,3};
        int arr2 []= {4,3 ,6};
        final List queryList = Arrays.asList(arr1);
        final List baseList = Arrays.asList(arr2);

        boolean c = queryList.stream().filter(q ->  baseList.stream()
                .noneMatch(b -> q==b)).count() > 0;
        int a = 9;*/

        WorkThread wt1 = new WorkThread();
        wt1.start();
        WorkThread wt2 = new WorkThread();
        wt2.start();

        Thread wt3 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }
        );

        Thread wt4 = new Thread(new SomeRunnable());
        wt3.start();


        LinkedList<Integer> adjListArray[] = new LinkedList[2];
        adjListArray[0] = new LinkedList<>();
    }
}

class SomeRunnable implements Runnable {
    public final void run() {

    }
}

interface abc {
    int a =9;
    public void sme();
}

class WorkThread extends Thread {

    public void run() {
        int c = 1;
        while(c<10) {
            System.out.println(c);
            c++;
        }
    }
}
