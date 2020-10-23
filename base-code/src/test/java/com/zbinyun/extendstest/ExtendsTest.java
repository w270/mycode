package com.zbinyun.extendstest;

public class ExtendsTest {
    public static void main(String[] args)  {
        A a = new B();
        test(a);
    }

    public static void test(A a){
        System.out.println("test A");
        a.whoAmI();
    }

    public static void test(B b){
        System.out.println("test B");
        b.whoAmI();
    }
}

class A {
    public void whoAmI(){
        System.out.println("i am A");
    }
}

class B extends A {
    public void whoAmI(){
        System.out.println("i am B");
    }
}
