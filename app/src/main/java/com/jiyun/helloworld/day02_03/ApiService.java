package com.jiyun.helloworld.day02_03;

import com.jiyun.helloworld.day02_03.bean.FuLi;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ASAS on 2019/5/29.
 */

public interface ApiService {
    String girlUrl ="http://gank.io/";

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<FuLi> testRxjava();
}
