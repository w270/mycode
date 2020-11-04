package com.zbinyun.lottery;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomChoose {
    private Set<Integer> redsBall = new HashSet();
    private Set<Integer> bluesBall = new HashSet();

    public void random(){
        Random random = new Random();
        while (redsBall.size() < 5){
            int r = random.nextInt(35)+ 1;
            redsBall.add(r);
        }
        while (bluesBall.size() < 2){
            int r = random.nextInt(12)+ 1;
            bluesBall.add(r);
        }
    }
    public void randomDoubleBall(){
        Random random = new Random();
        while (redsBall.size() < 6){
            int r = random.nextInt(33)+ 1;
            redsBall.add(r);
        }
        while (bluesBall.size() < 1){
            int r = random.nextInt(16)+ 1;
            bluesBall.add(r);
        }
    }
    public static void main(String[] args) {
        RandomChoose rc = new RandomChoose();
        rc.random();
        //rc.redsBall.forEach(System.out::println);
        System.out.println(rc.redsBall);
        System.out.println(rc.bluesBall);
    }
}
