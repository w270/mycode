package com.zbinyun.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class DistributeClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient client = new DistributeClient();
        //1.获取zookeeper
        client.getConnect();
        //2.注册监听
        client.getChildren();
        //3业务逻辑处理
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers", true);
        //存储服务器节点主机名称集合
        ArrayList<String> hosts = new ArrayList<>();
        children.forEach(s ->{
            try {
                byte[] data = zkClient.getData("/servers/" + s, false, null);
                hosts.add(new String(data));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //打印出所有主机名到控制台
        System.out.println(hosts);
    }

    //创建连接
    private String connectString = "127.0.0.1:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                //监听只是一次，放进这里监听每一次
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
