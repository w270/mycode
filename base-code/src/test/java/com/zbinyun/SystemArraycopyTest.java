package com.zbinyun;

public class SystemArraycopyTest {
    public static void main(String[] args) {
        int[] src = {0,1,2,3,4};
        int[] obj = new int[5];
        System.arraycopy(src,0,obj,0,1);
        System.out.println(obj);
    }
}
