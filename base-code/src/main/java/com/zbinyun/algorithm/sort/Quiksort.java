package com.zbinyun.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//原理能说明，但是很浪费空间和时间,不采取
public class Quiksort {
    public static void sort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            Integer chosenItem = items.get(items.size()/2);
            for (Integer i : items) {
                if (i < chosenItem)
                    smaller.add(i);
                else if(i > chosenItem){
                    larger.add(i);
                }
                else same.add(i);
            }
            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(6);
        sort(list);
        list.forEach(s -> System.out.print(s+ " "));
    }
}
