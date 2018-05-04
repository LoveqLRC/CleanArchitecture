package com.loveqrc.cleanarchitecture;

import android.app.Application;

import com.loveqrc.cleanarchitecture.di.components.ApplicationComponent;
import com.loveqrc.cleanarchitecture.di.components.DaggerApplicationComponent;
import com.loveqrc.cleanarchitecture.di.modules.ApplicationModule;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class AndroidApplication extends Application {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
