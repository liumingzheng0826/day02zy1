package com.jiyun.helloworld.day02_03.model;

import com.jiyun.helloworld.day02_03.bean.FuLi;

import java.util.List;

/**
 * Created by ASAS on 2019/5/29.
 */

public interface ICallback {
    void getCG(List<FuLi.ResultsBean> resultsBeans);
    void getSB(String error);
}
