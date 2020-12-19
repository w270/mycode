package com.zbinyun.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author zhibin
 * @version 1.0
 * @date 2020/12/19 10:27
 */
public class PrintAction extends RecursiveAction {
    private static final long serialVersionUID = 1L;

    private static final int THRESHOLD = 9;

    private  int start;

    private  int end;

    public PrintAction(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        if(end - start  < THRESHOLD) {
            for(int i=start;i<=end;i++) {
                System.out.println(Thread.currentThread().getName()+",i="+i);
            }
        }else {
            int middle = (start + end) / 2;
            PrintAction firstTask = new PrintAction(start,middle);
            PrintAction secondTask = new PrintAction(middle+1,end);
            invokeAll(firstTask,secondTask);
        }
    }
}
