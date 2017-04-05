package com.text.dukang.lasttextmutltype.util;

import android.content.Context;

import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.data.ContentData01;
import com.text.dukang.lasttextmutltype.data.ContentData02;
import com.text.dukang.lasttextmutltype.data.ContentData03;
import com.text.dukang.lasttextmutltype.data.ContentData04;
import com.text.dukang.lasttextmutltype.data.ContentData05;
import com.text.dukang.lasttextmutltype.data.ContentData10;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 14:13
 * @Description :
 */

public class HomeDealUtil {

    public static void dataDeal(Context context,ContentBean contentBean){
        switch (contentBean.getType()){
            case 1:
                ContentData01 contentData01=new ContentData01(context,contentBean);
                DataMagr.addList(contentData01);
                break;
            case 2:
                ContentData02 contentData02=new ContentData02(context,contentBean);
                DataMagr.addList(contentData02);
                break;
            case 3:
                ContentData03 contentData03=new ContentData03(context,contentBean);
                DataMagr.addList(contentData03);
                break;
            case 4:
                ContentData04 contentData04=new ContentData04(context,contentBean);
                DataMagr.addList(contentData04);
                break;
            case 5:
                ContentData05 contentData05=new ContentData05(context,contentBean);
                DataMagr.addList(contentData05);
                break;
            case 10:
                ContentData10 contentData10=new ContentData10(context,contentBean);
                DataMagr.addList(contentData10);
        }
    }

}
