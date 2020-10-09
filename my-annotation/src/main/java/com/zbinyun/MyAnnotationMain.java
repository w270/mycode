package com.zbinyun;

import com.zbinyun.fruit.Apple;
import com.zbinyun.util.FruitInfoUtil;

public class MyAnnotationMain {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
