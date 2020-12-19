package com.zbinyun.forkjoin;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author zhibin
 * @version 1.0
 * @date 2020/12/19 10:40
 */
public class ThreadPollUtils {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new ThreadPollUtils().test();

    }
    public void test() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new RecursiveTask<Integer>(){

            @Override
            protected Integer compute() {
                try {
                    return getMyInteger(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        ForkJoinTask<Integer> task1 = pool.submit(new RecursiveTask<Integer>(){

            @Override
            protected Integer compute() {
                try {
                    return getMyInteger1(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        long s = new Date().getTime();
        System.out.println("===================="
        );
        Integer result = task.get();
        Integer result1 = task1.get();
        pool.shutdown();


        System.out.println(result + "==========="  +result1);
    }
    public Integer getMyInteger(Integer p) throws InterruptedException {
        System.out.println("enter ============  myinteger");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("out =============== myinteger");
        return p;
    }
    public Integer getMyInteger1(Integer p) throws InterruptedException {
        System.out.println("enter ============  1");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("out =============== 1");
        return p;
    }

}
