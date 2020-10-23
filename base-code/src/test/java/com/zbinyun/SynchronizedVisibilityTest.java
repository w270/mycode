package com.zbinyun;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * synchronizced 的可见性
 */
public class SynchronizedVisibilityTest {
    private int shareVariable = 0;
    public int getShareVariable(){
        return shareVariable;
    }
    public synchronized void modifyShareVariable(){
        shareVariable = 10;
    }
    public static void main(String[] args) {
        SynchronizedVisibilityTest test = new SynchronizedVisibilityTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start:"+test.getShareVariable());
                test.modifyShareVariable();
                System.out.println("end:"+test.getShareVariable());
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("sleep结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("main:"+test.getShareVariable());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
