package com.zbinyun.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class ZookeeperTest {
    //192.168.2.201	mqnode1
    //192.168.2.202	mqnode2
    //192.168.2.68	mqnode3
    //必须使用hostname，不能使用IP地址
    //集群
//    private String connectString = "mqnode1:2181,mqnode2:2181,mqnode3:2181";
    private String connectString = "127.0.0.1:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
//                System.out.println("============================");
//                try {
//                    List<String> children = zkClient.getChildren("/", true);
//                    for (int i = 0;i < children.size();i++){
//                        System.out.println(children.get(i));
//                    }
//                } catch (KeeperException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


            }
        });
    }
    //创建节点
    @Test
    public void create() throws KeeperException, InterruptedException {
        String path = zkClient.create("/zbinyun", "zbin".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);

    }

    //获取子节点，并监控
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);

        for (int i = 0;i < children.size();i++){
            System.out.println(children.get(i));
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    //获取子节点，并监控
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/zbinyun", false);
        System.out.println(stat);
    }
}
