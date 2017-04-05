package com.text.dukang.lasttextmutltype.holder;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.text.dukang.lasttextmutltype.R;
import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;
import com.text.dukang.lasttextmutltype.data.ContentData05;
import com.text.dukang.lasttextmutltype.data.ContentData10;
import com.text.dukang.lasttextmutltype.view.HorizontalScrollViewAdapter;
import com.text.dukang.lasttextmutltype.view.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/20 10:26
 * @Description :
 */

public class Type10ViewHolder extends BaseViewHolder<ContentData10> {

    private HorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;

    public Type10ViewHolder(View itemView, Context context) {
        super(itemView, context);
    }

    @Override
    public void setUpView(ContentData10 model, int position, HomeRecyclerAdapter homeRecyclerAdapter) {
        final List<String> mDatas = new ArrayList<>();
        mHorizontalScrollView = (HorizontalScrollView) itemView.findViewById(R.id.id_horizontalScrollView);
        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R.id.id_gallery);
        mDatas.clear();
        linearLayout.removeAllViews();
        for (int i = 0; i < model.getContentBean().getBannerList().size(); i++) {
//            mDatas.add(model.getContentBean().getBannerList().get(i).getPicUrl());

            View view = View.inflate(context, R.layout.activity_index_gallery_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
            Glide.with(context).load(model.getContentBean().getBannerList().get(i).getPicUrl()).into(imageView);
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ""+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(view);
        }


    }
}
