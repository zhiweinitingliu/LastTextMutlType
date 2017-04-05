package com.text.dukang.lasttextmutltype.holder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.text.dukang.lasttextmutltype.R;
import com.text.dukang.lasttextmutltype.adapter.GridViewAdapter;
import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;
import com.text.dukang.lasttextmutltype.adapter.ViewPagerAdapter;
import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.data.ContentData01;
import com.text.dukang.lasttextmutltype.data.ContentData02;
import com.text.dukang.lasttextmutltype.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/20 10:26
 * @Description :
 */

public class Type02ViewHolder extends BaseViewHolder<ContentData02> {

    public Type02ViewHolder(View itemView, Context context) {
        super(itemView, context);
    }


    private ViewPager viewPager;

    /**
     * 每一页显示的个数
     */
    private int pageSize = 10;

    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;

    /**
     * 总的页数
     */
    private int pageCount;

    private List<View> mPagerList;

    private List<ContentBean.BannerListBean> mDatas;
    private LayoutInflater inflater;

    @Override
    public void setUpView(ContentData02 model, int position, HomeRecyclerAdapter homeRecyclerAdapter) {
//        viewPager = (ViewPager) itemView.findViewById(R.id.viewpager);
//        mDatas = model.getContentBean().getBannerList();
//        //总的页数=总数/每页数量，并取整
//        pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
//        mPagerList = new ArrayList<>();
//
//        int iconHeight = Util.getScreenHeight(context) / 5;
//        int iconWidth = Util.getScreenWeight(context) / 5;
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(iconWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        inflater = LayoutInflater.from(context);
//        for (int i = 0; i < pageCount; i++) {
//            View parentView = inflater.inflate(R.layout.item_icon, viewPager, false);
//
//            mPagerList.add(parentView);
//
//
//            //设置适配器
//            viewPager.setAdapter(new ViewPagerAdapter(mPagerList));
//        }
        TextView textView1 = (TextView) itemView.findViewById(R.id.text1);
        ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
        Glide.with(context).load(model.getContentBean().getBannerList().get(0).getPic().getNormal()).into(imageView1);
        textView1.setText(model.getContentBean().getBannerList().get(0).getTitle());

        TextView textView2 = (TextView) itemView.findViewById(R.id.text2);
        ImageView imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
        Glide.with(context).load(model.getContentBean().getBannerList().get(1).getPic().getNormal()).into(imageView2);
        textView2.setText(model.getContentBean().getBannerList().get(1).getTitle());

        TextView textView3 = (TextView) itemView.findViewById(R.id.text3);
        ImageView imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);
        Glide.with(context).load(model.getContentBean().getBannerList().get(2).getPic().getNormal()).into(imageView3);
        textView3.setText(model.getContentBean().getBannerList().get(2).getTitle());

        TextView textView4 = (TextView) itemView.findViewById(R.id.text4);
        ImageView imageView4 = (ImageView) itemView.findViewById(R.id.imageView4);
        Glide.with(context).load(model.getContentBean().getBannerList().get(3).getPic().getNormal()).into(imageView4);
        textView4.setText(model.getContentBean().getBannerList().get(3).getTitle());

        TextView textView5 = (TextView) itemView.findViewById(R.id.text5);
        ImageView imageView5 = (ImageView) itemView.findViewById(R.id.imageView5);
        Glide.with(context).load(model.getContentBean().getBannerList().get(4).getPic().getNormal()).into(imageView5);
        textView5.setText(model.getContentBean().getBannerList().get(4).getTitle());

        TextView textView6 = (TextView) itemView.findViewById(R.id.text6);
        ImageView imageView6 = (ImageView) itemView.findViewById(R.id.imageView6);
        Glide.with(context).load(model.getContentBean().getBannerList().get(5).getPic().getNormal()).into(imageView6);
        textView6.setText(model.getContentBean().getBannerList().get(5).getTitle());

        TextView textView7 = (TextView) itemView.findViewById(R.id.text7);
        ImageView imageView7 = (ImageView) itemView.findViewById(R.id.imageView7);
        Glide.with(context).load(model.getContentBean().getBannerList().get(6).getPic().getNormal()).into(imageView7);
        textView7.setText(model.getContentBean().getBannerList().get(6).getTitle());

        TextView textView8 = (TextView) itemView.findViewById(R.id.text8);
        ImageView imageView8 = (ImageView) itemView.findViewById(R.id.imageView8);
        Glide.with(context).load(model.getContentBean().getBannerList().get(7).getPic().getNormal()).into(imageView8);
        textView8.setText(model.getContentBean().getBannerList().get(7).getTitle());

        TextView textView9 = (TextView) itemView.findViewById(R.id.text9);
        ImageView imageView9 = (ImageView) itemView.findViewById(R.id.imageView9);
        Glide.with(context).load(model.getContentBean().getBannerList().get(8).getPic().getNormal()).into(imageView9);
        textView9.setText(model.getContentBean().getBannerList().get(8).getTitle());

        TextView textView10 = (TextView) itemView.findViewById(R.id.text10);
        ImageView imageView10 = (ImageView) itemView.findViewById(R.id.imageView10);
        Glide.with(context).load(model.getContentBean().getBannerList().get(9).getPic().getNormal()).into(imageView10);
        textView10.setText(model.getContentBean().getBannerList().get(9).getTitle());
    }
}
