package org.cs294639693.flux;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaBolt extends BaseRichBolt {
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        System.out.println("prepare ===================== :" + map.get("test"));
    }

    @Override
    public void execute(Tuple tuple) {
//        String msg=tuple.getStringByField("Users");
        HashMap csqHashMap = new HashMap();
        JSONObject jsonObject new JSONObject();
        List list = new ArrayList<HashMap>();
        tuple.getByteByField("Users");
        jsonObject = JSONObject

        csqHashMap.putAll();

        System.out.println("开始分割单词:" + tuple.getValues().get(0));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("Users"));


    }
}
