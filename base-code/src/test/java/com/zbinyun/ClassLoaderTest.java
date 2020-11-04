package com.zbinyun;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;

public class ClassLoaderTest {
    private String name;
    public ClassLoaderTest(String text){
        System.out.println("这是构造器："+text);
    }
    public static void sayHello(){
        System.out.println("hello ");
    }
    static {
        sayHello();
    }
    public static void main(String[] args) {
        try {
            //class.forName 加载方式
            Class<?> classForName = Class.forName("com.zbinyun.ClassLoaderTest");
//            Constructor<?> constructor1 = classForName.getConstructor(String.class);
//            constructor1.newInstance("加载方式Class.forName:有一个参数的构造器");
            System.out.println("===========================================");
            //loader加载方式
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class<?> classLoaderClass = classLoader.loadClass("com.zbinyun.ClassLoaderTest");
//            Constructor<?> constructor2 = classLoaderClass.getConstructor(String.class);
//            constructor2.newInstance("加载方式ClassLoader:有一个参数的构造器");
        }catch (Exception e){

        }
    }
}
