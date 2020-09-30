package com.zbinyun.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();
        //1.连接zookeeper
        server.getConnect();
        //2.注册节点
        server.regist(args[0]);
        //3.业务逻辑
        server.business();
    }
    //让服务一直运行，模拟
    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
    //注册，就是创建节点
    private void regist(String hostname) throws KeeperException, InterruptedException {
        String path = zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL); //创建临时带序号的节点
        System.out.println(hostname+ " is online");
    }

    //创建连接
    private String connectString = "127.0.0.1:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
