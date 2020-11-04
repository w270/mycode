package com.zbinyun.DesignPattern.CreationalPattern.SingletonPattern;

/**
 * 单例-恶汉式
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
