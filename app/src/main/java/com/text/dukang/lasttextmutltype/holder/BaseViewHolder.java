package com.text.dukang.lasttextmutltype.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/20 10:08
 * @Description :
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public Context context;
    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.context=context;
    }

    public abstract void setUpView(T model, int position, HomeRecyclerAdapter homeRecyclerAdapter);
}
