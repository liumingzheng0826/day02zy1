package com.jiyun.helloworld.day02_03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jiyun.helloworld.day02_03.R;
import com.jiyun.helloworld.day02_03.bean.FuLi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASAS on 2019/5/29.
 */

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder>{

    private Context mContext;
    private List<FuLi.ResultsBean> mList = new ArrayList<>();

    public RlvAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RlvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.rlv_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RlvAdapter.ViewHolder holder, final int position) {
        FuLi.ResultsBean resultsBean = mList.get(position);
        RequestOptions options = RequestOptions.centerCropTransform();
        Glide.with(mContext).load(resultsBean.getUrl()).apply(options).into(holder.img);
        holder.tv.setText(resultsBean.getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<FuLi.ResultsBean> resultsBeans) {
        if (this.mList!=null){
            this.mList.clear();
            this.mList.addAll(resultsBeans);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
    private OnItemClickListener onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public interface OnItemClickListener{
            void onClick(View v,int position);
        }
}
