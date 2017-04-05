package com.text.dukang.lasttextmutltype.data;

import android.content.Context;

import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.factory.TypeFactory;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 13:30
 * @Description :
 */

public abstract class BaseData {
    private int type;
    private ContentBean contentBean;
    private Context context;

    public BaseData(Context context,ContentBean contentBean){
        this.context=context;
        this.contentBean=contentBean;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ContentBean getContentBean() {
        return contentBean;
    }

    public void setContentBean(ContentBean contentBean) {
        this.contentBean = contentBean;
    }

    public abstract int type(TypeFactory typeFactory);

}
