package com.zbinyun.jdkproxy.impl;

import com.zbinyun.jdkproxy.Human;

//被代理类
public class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
