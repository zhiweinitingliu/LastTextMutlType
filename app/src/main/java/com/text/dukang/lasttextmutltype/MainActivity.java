package com.text.dukang.lasttextmutltype;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.text.dukang.lasttextmutltype.adapter.HomeRecyclerAdapter;
import com.text.dukang.lasttextmutltype.bean.ContentBean;
import com.text.dukang.lasttextmutltype.bean.HomeBean;
import com.text.dukang.lasttextmutltype.listener.EndLessOnScrollListener;
import com.text.dukang.lasttextmutltype.util.DataMagr;
import com.text.dukang.lasttextmutltype.util.FileUtils;
import com.text.dukang.lasttextmutltype.util.HomeDealUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private HomeRecyclerAdapter homeRecyclerAdapter;
    private View headView;
    private View footView;
    private SwipeRefreshLayout swipeRefreshLayout;

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
        headView = View.inflate(context, R.layout.header_view, null);
        footView = View.inflate(context, R.layout.footer_view, null);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        homeRecyclerAdapter = new HomeRecyclerAdapter(context);
        homeRecyclerAdapter.addHeadView(headView);
        homeRecyclerAdapter.addFootView(footView);

//        final GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return homeRecyclerAdapter.getSpanCount(gridLayoutManager);
//            }
//        });
//        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeRecyclerAdapter);
        initRefresh();
        initLoadmore();
    }

    private void initLoadmore() {
        recyclerView.addOnScrollListener(new EndLessOnScrollListener() {
            @Override
            public void onLoadMore(Loading loading) {
                handler.sendEmptyMessageDelayed(101, 2000);
            }
        });
    }

    private void initRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100, 2000);
            }
        });
    }


    private String jsonData;

    private void initData() {

        jsonData = FileUtils.readJsonFile(this, "json").replace(" ", "");
        HomeBean homeBean = JSON.parseObject(jsonData, HomeBean.class);
        List<ContentBean> contentBeanList = homeBean.getBody().getContent();
        for (int i = 0; i < contentBeanList.size(); i++) {
            HomeDealUtil.dataDeal(context, contentBeanList.get(i));
        }

        homeRecyclerAdapter.setData(DataMagr.getDataList());
        homeRecyclerAdapter.notifyDataSetChanged();
    }
}
