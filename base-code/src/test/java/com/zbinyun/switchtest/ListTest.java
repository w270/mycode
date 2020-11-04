package com.zbinyun.switchtest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ListTest {
    @Test
    public void testListRemove(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list) {
        list.remove(2);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
