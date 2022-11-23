package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] merger(T[] arrayToMerge) {
        List<T> merger = new ArrayList<>();
        merger.addAll(List.of(inputArray));
        merger.addAll(List.of(arrayToMerge));
        inputArray = (T[]) Array.newInstance(merger.get(0).getClass(),merger.size());
        for(int i = 0; i < merger.size(); i++) {
            inputArray[i] = merger.get(i);
        }
        return inputArray;
    }
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int count = 0;
        this.inputArray = merger(arrayToMerge);
        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T result = null;
        int mostCommonCounter = 0;
        this.inputArray = merger(arrayToMerge);
        for(int i = 0; i < inputArray.length-1; i++) {
            int counter = 0;
            for(int j = i+1; j < inputArray.length; j++) {
                if(inputArray[i].equals(inputArray[j])) {
                    counter++;
                    if(mostCommonCounter < counter) {
                        mostCommonCounter = counter;
                        result = arrayToMerge[i];
                    }
                }
            }
        }
        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;
        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        int j = 0;
        List<T> temp = new ArrayList<>();
        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] != valueToRemove) {
                temp.add(j,inputArray[i]);
                j++;
            }
        }
        inputArray = (T[]) Array.newInstance(temp.get(0).getClass(),temp.size());
        for(int i = 0; i < temp.size(); i++) {
            inputArray[i] = temp.get(i);
        }
        return inputArray;
    }
}
