package com.text.dukang.lasttextmutltype.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.text.dukang.lasttextmutltype.R;
import com.text.dukang.lasttextmutltype.data.BaseData;
import com.text.dukang.lasttextmutltype.factory.TypeFactoryforList;
import com.text.dukang.lasttextmutltype.holder.BaseViewHolder;
import com.text.dukang.lasttextmutltype.holder.FootViewHolder;
import com.text.dukang.lasttextmutltype.holder.HeadViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/17 14:08
 * @Description :
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<BaseData> homeDataList;
    private TypeFactoryforList typeFactoryforList;
    private List<View> headViews;
    private List<View> footViews;

    private static final int HEAD_VIEW_TYPE = 1001;
    private static final int FOOT_VIEW_TYPE = 1002;


    public HomeRecyclerAdapter(Context context, List<BaseData> homeDataList) {
        this.context = context;
        this.typeFactoryforList = new TypeFactoryforList();
        this.homeDataList = homeDataList;
        headViews = new ArrayList<>();
        footViews = new ArrayList<>();
    }

    public void setData(List<BaseData> newDataList) {
        homeDataList.addAll(newDataList);
    }

    public void clearDate() {
        homeDataList.clear();
    }

    /**
     * 添加头布局
     *
     * @param view 头布局view
     */
    public void addHeadView(View view) {
        if (headViews != null) {
            headViews.add(view);
        }
    }

    /**
     * 添加脚布局
     *
     * @param view 脚布局的view
     */
    public void addFootView(View view) {
        if (footViews != null) {
            footViews.add(view);
        }
    }

    /**
     * 清除头布局
     */
    public void clearHeadViews() {
        if (headViews != null) {
            headViews.clear();
        }
    }

    /**
     * 清除脚布局
     */
    public void clearFootViews() {
        if (footViews != null) {
            footViews.clear();
        }
    }

    public void setSpanCount(GridLayoutManager gridLayoutManager) {
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = getItemViewType(position);
                if (type == TypeFactoryforList.type05) {
                    return 1;//只占一行中的一列，
                } else {
                    return 2;//独占一行
                }
            }
        });
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_VIEW_TYPE) {
            return new HeadViewHolder(headViews.get(0), context);
        } else if (viewType == FOOT_VIEW_TYPE) {
            return new FootViewHolder(footViews.get(0), context);
        }

        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return typeFactoryforList.creatBaseViewHolder(viewType, view, context);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder != null && position >= headViews.size() && position < headViews.size() + homeDataList.size()) {
            holder.setUpView(homeDataList.get(position - headViews.size()), position, this);
        }
    }

    @Override
    public int getItemCount() {
        return homeDataList == null ? 0 : homeDataList.size() + headViews.size() + getFooSize();
    }

    @Override
    public int getItemViewType(int position) {

        int contentSize = homeDataList.size();
        int headViewSize = headViews.size();
        int footViewSize = footViews.size();

        if (position >= 0 && position < headViewSize) {
            return HEAD_VIEW_TYPE;
        } else if (position >= headViewSize && position < headViewSize + contentSize) {
            return homeDataList.get(position - headViewSize).type(typeFactoryforList);
        } else {
            return FOOT_VIEW_TYPE;
        }
    }

    public int getFooSize() {
        return homeDataList.size() > 10 ? footViews.size() : 0;//在开发中会有分页，如果分页的时候每页返回15调数据，当返回10条的时候就是只有一页，10条可能不能占满屏幕，所以不显示脚布局
    }
}
