package com.zbinyun;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
@Slf4j
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        service.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("time:");
                    }
                }, 0, 1000, TimeUnit.MILLISECONDS
        );//0表示首次执行任务的延迟时间，40表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位

    }
}
