package json;


import java.util.*;
public class RawdataDecode {
    public static Map<String,String> decode(String rawData) {
        //String rawData = "6811D200050107D200040164D200280108D20023020005D20029020118D20025020003D20039020004D20043020002D200440105EA16";
        rawData = rawData.substring(4);
        rawData = rawData.substring(0,rawData.length()-4);

        String[] rawDataSplit = rawData.split("D2");

        //System.out.println(rawData);
        Map<String,String> result = new LinkedHashMap<>();
        int k=0;
        for (String rawDataSplitValue: rawDataSplit) {
            if(rawDataSplitValue.isEmpty()) continue;
            String Definition = rawDataSplitValue.substring(0,4);
            //String length = rawDataSplitValue.substring(5,6);
            String value = rawDataSplitValue.substring(6, rawDataSplitValue.length());
            result.put(Definition, value);

            k++;
        }

        return result;
    }

    public static Map<String,String> decodeWithDefinition(String rawData) {
        //String rawData = "6811D200050107D200040164D200280108D20023020005D20029020118D20025020003D20039020004D20043020002D200440105EA16";
        rawData = rawData.substring(4);
        rawData = rawData.substring(0,rawData.length()-4);

        String[] rawDataDefinition ={"设备状态","电池电量","心跳周期","液位值","温度","低液位值","液位启动值","液位变化值","采样周期"};

        String[] rawDataSplit = rawData.split("D2");

        //System.out.println(rawData);
        Map<String,String> result = new LinkedHashMap<>();
        int k=0;
        for (String rawDataSplitValue: rawDataSplit) {
            if(rawDataSplitValue.isEmpty()) continue;
            String Definition = rawDataSplitValue.substring(0,4);
            //String length = rawDataSplitValue.substring(5,6);
            String value = rawDataSplitValue.substring(6, rawDataSplitValue.length());
            result.put(rawDataSplitValue,rawDataDefinition[k]+"("+Definition+"):value:"+value);
            //System.out.println(rawDataSplitValue+","+rawDataDefinition[k]+"("+Definition+"):value:"+value);
            k++;
        }

        return result;
    }
}