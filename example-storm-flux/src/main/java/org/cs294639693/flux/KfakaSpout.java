package org.cs294639693.flux;

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

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("init mothend!!!");
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
        csqHashMap.put("UserID", "001");
        csqHashMap.put("UserName", "csq");
        String[] message = {
                "aa", "bb"
        };

        List list = new ArrayList();
        list.add(csqHashMap);
        int count = 0;
        if (count > 1) {
            this.spoutOutputCollector.emit(list);
        }
        count ++;
    }

        @Override
        public void close () {
            super.close();
        }
    }
