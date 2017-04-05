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
    private int lastPosition = -1;


    public HomeRecyclerAdapter(Context context) {
        this.context = context;
        this.typeFactoryforList = new TypeFactoryforList();
        headViews = new ArrayList<>();
        footViews = new ArrayList<>();
    }

    public void setData(List<BaseData> homeDataList) {
        this.homeDataList = homeDataList;
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

    public enum ViewType {
        Header(0), Footer(1), Grid(2);

        public final int value;

        ViewType(int value) {
            this.value = value;
        }

        public static ViewType fromValue(int value) {
            for (ViewType type : ViewType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            return null;
        }
    }


//    private ViewType itemViewType = ViewType.Grid;

    int viewtype = 2;

    public int getSpanSize(GridLayoutManager gridLayoutManager) {

        Log.e("getSpanSize", "getSpanSize: " + viewtype);

        return viewtype;
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

//    @Override
//    public void onViewDetachedFromWindow(BaseViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//
////        holder.ll_content.clearAnimation();
//    }

    public int getSpanCount(GridLayoutManager gridLayoutManager) {
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = getItemViewType(position);
                if (type == TypeFactoryforList.type05) {
                    return 1;//只占一行中的一列，
                } else {
                    return 2;//独占一行
//                    return gridLayoutManager.getSpanCount();//独占一行
                }
            }
        });
        return 2;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_VIEW_TYPE) {
            return new HeadViewHolder(LayoutInflater.from(context).inflate(R.layout.header_view, parent, false), context);
        } else if (viewType == FOOT_VIEW_TYPE) {
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.footer_view, parent, false), context);
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
        return homeDataList == null ? 0 : homeDataList.size() + headViews.size() + footViews.size();
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
}
