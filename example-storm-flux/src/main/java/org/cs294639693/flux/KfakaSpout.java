package org.cs294639693.flux;

import org.apache.storm.shade.org.json.simple.JSONObject;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KfakaSpout extends BaseRichSpout {

    private SpoutOutputCollector spoutOutputCollector;
    int count = 0;
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("初始化 spout !!");
        this.spoutOutputCollector = spoutOutputCollector;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        System.out.println("定义格式...");
        outputFieldsDeclarer.declare(new Fields("Users"));

    }

    @Override
    public void nextTuple() {
        HashMap csqHashMap = new HashMap();
        List <HashMap>list = new ArrayList<HashMap>();
        csqHashMap.put("UserID", "001");
        csqHashMap.put("UserName", "csq");
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(csqHashMap);
        String[] message = {
                "aa", "bb"
        };


        list.add(csqHashMap);

        if (count < 1) {
            this.spoutOutputCollector.emit(new Values(jsonObject.toJSONString()));
            System.out.printf("发送数据！！");
        }
        count ++;
    }

        @Override
        public void close () {
            super.close();
        }
    }
