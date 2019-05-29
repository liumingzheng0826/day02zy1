package com.jiyun.helloworld.day02_03.presenter;

import com.jiyun.helloworld.day02_03.bean.FuLi;
import com.jiyun.helloworld.day02_03.model.ICallback;
import com.jiyun.helloworld.day02_03.model.ModelImpl;
import com.jiyun.helloworld.day02_03.view.IView;

import java.util.List;

/**
 * Created by ASAS on 2019/5/29.
 */

public class PresenterImpl implements IPresenter {
    IView iView;
    private final ModelImpl model;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        model = new ModelImpl();
    }

    @Override
    public void getData() {
        if (model != null) {
            model.getDataFuli(new ICallback() {
                @Override
                public void getCG(List<FuLi.ResultsBean> resultsBeans) {
                    iView.getCG(resultsBeans);
                }

                @Override
                public void getSB(String error) {
                    iView.getSB(error);
                }
            });
        }
    }
}
