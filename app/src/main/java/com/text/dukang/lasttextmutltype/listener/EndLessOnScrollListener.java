package com.text.dukang.lasttextmutltype.listener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @Description XXX
 * @Author qyf
 * @Email 1063810202@qq.com
 * Created 2016/9/18 9:44.
 */
public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener {

    //获取LayoutManager
    private LinearLayoutManager myLayoutManager;

    //已经请求得到的所有item总数
    private int totalItemCount;

    //屏幕上可见的item数量
    private int visibleItemCount;

    //在屏幕可见的最后一个item的位置
    private int lastVisibleItem;

    //是否正在请求数据
//    private boolean loading = true;
    //当已经没有更多页的时候，需要将loading设为true  才可以在更改筛选方案之后自动加载正常
    private Loading loading = new Loading(true);

    public EndLessOnScrollListener() {
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dy < 0) {
            return;
        }

        visibleItemCount = recyclerView.getChildCount();

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager instanceof LinearLayoutManager) {  //LinearLayoutManager  and  GridLayoutManager
            myLayoutManager = (LinearLayoutManager) layoutManager;
        } else if (layoutManager instanceof GridLayoutManager) {
            myLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            return;
        }

        totalItemCount = myLayoutManager.getItemCount();
        lastVisibleItem = myLayoutManager.findLastVisibleItemPosition();


        if (loading.isLoading()) {
            if (lastVisibleItem < totalItemCount - 1) {
                //说明加载已经结束
                loading.setLoading(false);
            }
        }

        if (!loading.isLoading() && lastVisibleItem == totalItemCount - 1) {
            onLoadMore(loading);
        }

    }

    public abstract void onLoadMore(Loading loading);

    public class Loading {
        private boolean loading;

        public Loading(boolean loading) {
            this.loading = loading;
        }

        public boolean isLoading() {
            return loading;
        }

        public void setLoading(boolean loading) {
            this.loading = loading;
        }
    }
}