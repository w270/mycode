package com.zbinyun.jdkproxy;

public class ProxyTest {
    public  void test1() throws InterruptedException {
        synchronized(this) {
            int a = 1;
        }
    }
    public synchronized void test2() throws InterruptedException {

        System.out.println("start");
        System.out.println("end");

    }


    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        new Thread(()->{
            try {
                proxyTest.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                proxyTest.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
