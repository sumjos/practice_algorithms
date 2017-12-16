package com.company;

import com.company.searches.JumpSearch;
import com.company.searches.Search;

public class TestGenericJumpSearch {
    public static void main(String[] args) {

        Integer testArraySorted[] = {1,2,3,4,5,6,7,8,9,10,11,12,3,14,15,16};
        String strArray[] = {"a","b","c","d","e","f",};
        short indexToFind = 5;
        Search searchInteger = new JumpSearch<Integer>(testArraySorted, testArraySorted[indexToFind], Integer.class);
        System.out.println((searchInteger.doSearch() == indexToFind) ? testArraySorted[indexToFind] + "\t Found in number array" : "Element Not Found");

        Search searchString = new JumpSearch<String>(strArray, strArray[indexToFind], String.class);
        System.out.println((searchString.doSearch() == indexToFind) ? strArray[indexToFind] + "\tFound in string array" : "Element Not Found");

    }
}
