package org.cs294639693.flux;


import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class TestMain {
    public static void main(String[] args) {

        //定义一个拓扑
        TopologyBuilder builder = new TopologyBuilder();
        //设置一个Executeor(线程)，默认一个
        builder.setSpout("KfakaSpout_ID", new KfakaSpout(), 1);
        Config conf = new Config();
        conf.put("test", "");
        try {

            //运行拓扑
            if (args != null && args.length > 0) { //有参数时，表示向集群提交作业，并把第一个参数当做topology名称
                System.out.println("运行远程模式");
//               StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
            } else {  //没有参数时，本地提交
                //启动本地模式
                System.out.println("运行本地模式");
                LocalCluster cluster = new LocalCluster();
                cluster.submitTopology("Topology_name", conf, builder.createTopology());
                Thread.sleep(20000);
                //  //关闭本地集群
                cluster.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
