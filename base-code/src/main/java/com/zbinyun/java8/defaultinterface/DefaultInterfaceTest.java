package com.zbinyun.java8.defaultinterface;

public class DefaultInterfaceTest {
    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
        vehicle.print2();
    }
}
interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
    default void print2(){
        System.out.println("----print2");
    }
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
    @Override
    public void print2(){
        System.out.println("----print3");
    }
}