package com.text.dukang.lasttextmutltype.data;

import android.content.Context;

import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.factory.TypeFactory;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 13:38
 * @Description :
 */

public class ContentData02 extends BaseData {

    public ContentData02(Context context, ContentBean contentBean) {
        super(context, contentBean);
        setContentBean(contentBean);
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
