package com.text.dukang.lasttextmutltype.util;

import com.text.dukang.lasttextmutltype.data.BaseData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 10:02
 * @Description :使用泛型将修改后数据添加到集合当中
 */

public class DataMagr {

    public static final List<BaseData> dataList = new ArrayList<>();

    public static void addList(BaseData baseData) {
        dataList.add(baseData);
    }

    public static List<BaseData> getDataList() {
        return dataList;
    }

    public static void clearDataList() {
        dataList.clear();
    }
}
