package com.zbinyun;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringTest {
    public static void main(String[] args) {
        "".concat("");
        Map<String,String> map = new ConcurrentHashMap<>();
        String str1 = new String("111");
        String str2 = new String("222");
        map.putIfAbsent("1",str1);
        map.putIfAbsent("1",str2);
        System.out.println(map.get("1") == str2);
    }
}
