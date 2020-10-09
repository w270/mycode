package com.zbinyun.exception;

import lombok.Data;

@Data
public class MyException extends Exception{
    private int code;
    private String message;

    public MyException(int code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public static void main(String[] args) {
        try{
            test();
        }catch (MyException e){
            System.out.println(e.getCode()+"--"+e.getMessage());
        }

    }

    public static void test() throws MyException{
        throw new MyException(1,"222");
    }
}
