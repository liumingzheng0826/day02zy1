package com.jiyun.helloworld.day02_03.model;

import android.util.Log;

import com.jiyun.helloworld.day02_03.ApiService;
import com.jiyun.helloworld.day02_03.bean.FuLi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASAS on 2019/5/29.
 */

public class ModelImpl implements IModel {
    private static final String TAG = "ModelImpl";
    @Override
    public void getDataFuli(final ICallback iCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.girlUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FuLi> observable = apiService.testRxjava();
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FuLi>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: "+d.toString());
            }

            @Override
            public void onNext(FuLi fuLi) {
                List<FuLi.ResultsBean> results = fuLi.getResults();
                iCallback.getCG(results);
                Log.d(TAG, "onNext: "+results);
            }

            @Override
            public void onError(Throwable e) {
                iCallback.getSB(e.getMessage());
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
    }
}
