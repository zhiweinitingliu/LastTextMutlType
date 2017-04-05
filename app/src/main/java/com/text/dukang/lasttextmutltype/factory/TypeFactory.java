package com.text.dukang.lasttextmutltype.factory;

import android.content.Context;
import android.view.View;

import com.text.dukang.lasttextmutltype.data.ContentData01;
import com.text.dukang.lasttextmutltype.data.ContentData02;
import com.text.dukang.lasttextmutltype.data.ContentData03;
import com.text.dukang.lasttextmutltype.data.ContentData04;
import com.text.dukang.lasttextmutltype.data.ContentData05;
import com.text.dukang.lasttextmutltype.data.ContentData10;
import com.text.dukang.lasttextmutltype.holder.BaseViewHolder;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 13:33
 * @Description :
 */

public interface TypeFactory {


    int type(ContentData01 contentData01);

    int type(ContentData02 contentData02);

    int type(ContentData03 contentData03);

    int type(ContentData04 contentData04);

    int type(ContentData05 contentData05);

    int type(ContentData10 contentData10);

    BaseViewHolder creatBaseViewHolder(int type, View itemView, Context context);

}
