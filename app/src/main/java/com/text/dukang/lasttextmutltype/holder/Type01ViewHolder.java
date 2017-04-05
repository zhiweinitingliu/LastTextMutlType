package com.text.dukang.lasttextmutltype.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.text.dukang.lasttextmutltype.R;
import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;
import com.text.dukang.lasttextmutltype.data.ContentData01;
import com.text.dukang.lasttextmutltype.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/20 10:26
 * @Description :
 */

public class Type01ViewHolder extends BaseViewHolder<ContentData01> {

    public Type01ViewHolder(View itemView, Context context) {
        super(itemView, context);
    }

    @Override
    public void setUpView(ContentData01 model, int position, HomeRecyclerAdapter homeRecyclerAdapter) {
//        String[] imageUrls = new String[model.getContentBean().getBannerList().size()];
        List<String> imageUrls = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        if (model.getContentBean().getBannerList() != null) {
            for (int i = 0; i < model.getContentBean().getBannerList().size(); i++) {
//                imageUrls[i]=model.getContentBean().getBannerList().get(i).getPicUrl();
                imageUrls.add(model.getContentBean().getBannerList().get(i).getPicUrl());
                titles.add(model.getContentBean().getTitle());
            }
        }

        Banner banner = (Banner) itemView.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageUrls);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
