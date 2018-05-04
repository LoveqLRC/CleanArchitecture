package com.loveqrc.cleanarchitecture.view;

import android.content.Context;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String message);


    Context context();

}
