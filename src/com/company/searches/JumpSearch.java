package com.company.searches;

public class JumpSearch<T>  extends SearchTypeMapper<T> implements Search {

    public JumpSearch() {}

    public JumpSearch(T[] arr, T searchElement, Class<T> genericClass) {
        this.arr = arr;
        this.searchElement = searchElement;
        this.genericClass = genericClass;
    }

    @Override
    public int doSearch() {
        int blockSize = (int)Math.sqrt(arr.length);
        int blockStartIndex = 0;
        for (int index = 0; blockStartIndex < arr.length; index++) {
            int upperBlockIndex = (index+1)*blockSize - 1;
            upperBlockIndex = (upperBlockIndex < arr.length) ? upperBlockIndex : arr.length - 1;
            if (this.lessThanEqualCheck(searchElement, arr[blockStartIndex]) && this.greaterThanEqualCheck(searchElement, arr[upperBlockIndex])) {
                for (int searchIndex = blockStartIndex; searchIndex <= upperBlockIndex; searchIndex++) {
                    if (this.equalCheck(this.arr[searchIndex], this.searchElement)) {
                        return searchIndex;
                    }
                }
                return -1;
            }
            blockStartIndex = (index+1)*blockSize;
        }
        return -1;
    }
}
