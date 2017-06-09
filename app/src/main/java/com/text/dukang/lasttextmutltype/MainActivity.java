package com.text.dukang.lasttextmutltype;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;
import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.bean.HomeBean;
import com.text.dukang.lasttextmutltype.data.BaseData;
import com.text.dukang.lasttextmutltype.listener.EndLessOnScrollListener;
import com.text.dukang.lasttextmutltype.util.DataMagr;
import com.text.dukang.lasttextmutltype.util.FileUtils;
import com.text.dukang.lasttextmutltype.util.HomeDealUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Context context;
    private RecyclerView recyclerView;
    private HomeRecyclerAdapter homeRecyclerAdapter;
    private View headView;
    private View footView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int currentpage = 1;
    private int totalPage = 5;
    List<BaseData> dataList = new ArrayList<>();
    private ProgressBar progressBar;
    private TextView footText;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                case 101:
                    initData();
                    break;
                case 103:
                    setLoadNoMore();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        initView();
        initData();
    }

    private void initView() {

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        homeRecyclerAdapter = new HomeRecyclerAdapter(context, dataList);
        headView = View.inflate(context, R.layout.header_view, null);
        footView = View.inflate(context, R.layout.footer_view, null);
        progressBar = (ProgressBar) footView.findViewById(R.id.progressbar);
        footText = (TextView) footView.findViewById(R.id.footText);
        homeRecyclerAdapter.addHeadView(headView);
        homeRecyclerAdapter.addFootView(footView);

        /**
         * 线性布局
         */
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        recyclerView.setLayoutManager(layoutManager);

        /**
         * 网格布局
         */
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        homeRecyclerAdapter.setSpanCount(gridLayoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(homeRecyclerAdapter);
        initRefresh();
        initLoadmore();
    }

    private void initLoadmore() {
        recyclerView.addOnScrollListener(new EndLessOnScrollListener() {
            @Override
            public void onLoadMore(Loading loading) {
                Log.e(TAG, "onLoadMore: " + "我是加载更多" + currentpage);
                if (currentpage < totalPage) {
                    currentpage++;
                    handler.sendEmptyMessageDelayed(101, 2000);
                    setLoadMoreLoading();
                    loading.setLoading(true);
                } else {
                    loading.setLoading(false);
                    handler.sendEmptyMessageDelayed(103, 2000);
                }
            }
        });
    }

    private void initRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homeRecyclerAdapter.clearDate();
                currentpage = 1;
                initData();
                handler.sendEmptyMessageDelayed(100, 2000);
            }
        });
    }

    public void setLoadMoreLoading() {
        progressBar.setVisibility(View.VISIBLE);
        footText.setText("正在加载...");
    }

    public void setLoadNoMore() {
        progressBar.setVisibility(View.GONE);
        footText.setText("已加载全部数据^_^");
    }

    private String jsonData;

    private void initData() {

        jsonData = FileUtils.readJsonFile(this, "json").replace(" ", "");
        HomeBean homeBean = JSON.parseObject(jsonData, HomeBean.class);
        List<ContentBean> contentBeanList = homeBean.getBody().getContent();
        Log.e(TAG, "initData: " + contentBeanList.size());
        DataMagr.clearDataList();
        List<BaseData> dataList = HomeDealUtil.getDataList(context, contentBeanList);
        homeRecyclerAdapter.setData(dataList);
        homeRecyclerAdapter.notifyDataSetChanged();
    }
}
