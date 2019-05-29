package com.jiyun.helloworld.day02_03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jiyun.helloworld.day02_03.adapter.RlvAdapter;
import com.jiyun.helloworld.day02_03.bean.FuLi;
import com.jiyun.helloworld.day02_03.presenter.PresenterImpl;
import com.jiyun.helloworld.day02_03.view.IView;

import java.util.List;

//刘明政+H1810A
public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRlv;
    private RlvAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        PresenterImpl presenter = new PresenterImpl(this);
        presenter.getData();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RlvAdapter(this);
        mRlv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RlvAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void getCG(List<FuLi.ResultsBean> resultsBeans) {
        mAdapter.addData(resultsBeans);
    }

    @Override
    public void getSB(String error) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
