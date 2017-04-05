package com.text.dukang.lasttextmutltype.factory;

import android.content.Context;
import android.view.View;

import com.text.dukang.lasttextmutltype.R;
import com.text.dukang.lasttextmutltype.data.ContentData01;
import com.text.dukang.lasttextmutltype.data.ContentData02;
import com.text.dukang.lasttextmutltype.data.ContentData03;
import com.text.dukang.lasttextmutltype.data.ContentData04;
import com.text.dukang.lasttextmutltype.data.ContentData05;
import com.text.dukang.lasttextmutltype.data.ContentData10;
import com.text.dukang.lasttextmutltype.holder.BaseViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type01ViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type02ViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type03ViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type04ViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type05ViewHolder;
import com.text.dukang.lasttextmutltype.holder.Type10ViewHolder;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 13:40
 * @Description :
 */

public class TypeFactoryforList implements TypeFactory {

    public static final int type01 = R.layout.item_type01;
    public static final int type02 = R.layout.item_type02;
    public static final int type03 = R.layout.item_type03;
    public static final int type04 = R.layout.item_type04;
    public static final int type05 = R.layout.item_type05;
    public static final int type10 = R.layout.item_type10;



    @Override
    public int type(ContentData01 contentData01) {

        return type01;
    }

    @Override
    public int type(ContentData02 contentData02) {

        return type02;
    }

    @Override
    public int type(ContentData03 contentData03) {

        return type03;
    }

    @Override
    public int type(ContentData04 contentData04) {
        return type04;
    }

    @Override
    public int type(ContentData05 contentData05) {
        return type05;
    }

    @Override
    public int type(ContentData10 contentData10) {
        return type10;
    }

    @Override
    public BaseViewHolder creatBaseViewHolder(int type, View itemView, Context context) {
        switch (type) {
            case type01:
                return new Type01ViewHolder(itemView,context);
            case type02:
                return new Type02ViewHolder(itemView,context);
            case type03:
                return new Type03ViewHolder(itemView,context);
            case type04:
                return new Type04ViewHolder(itemView,context);
            case type05:
                return new Type05ViewHolder(itemView,context);
            case type10:
                return new Type10ViewHolder(itemView,context);
        }
        return null;
    }
}
