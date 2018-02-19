package com.company;

import com.google.gson.JsonElement;

import java.util.*;

public class TestScannerClass {
    public static void main(String[] args) {
        //final Set<Map.Entry<String, JsonElement>> entrySet = queryElement.getAsJsonObject().entrySet();
        //return entrySet.parallelStream().allMatch(entry -> matches(entry.getValue(), bElObj.get(entry.getKey())));
        int arr1 []= {1,2 ,3};
        int arr2 []= {4,3 ,6};
        final List queryList = Arrays.asList(arr1);
        final List baseList = Arrays.asList(arr2);

        boolean c = queryList.stream().filter(q ->  baseList.stream()
                .noneMatch(b -> q==b)).count() > 0;
        int a = 9;
    }
}
