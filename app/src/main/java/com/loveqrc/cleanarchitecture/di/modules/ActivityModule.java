package com.loveqrc.cleanarchitecture.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.loveqrc.cleanarchitecture.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */

@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    AppCompatActivity activity() {
        return mActivity;
    }
}
