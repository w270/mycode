package com.zbinyun.DesignPattern.CreationalPattern.SingletonPattern;

/**
 * 单例，内部静态类
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
