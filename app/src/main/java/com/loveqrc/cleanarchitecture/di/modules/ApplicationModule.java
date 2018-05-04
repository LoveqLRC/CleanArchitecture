package com.loveqrc.cleanarchitecture.di.modules;

import android.content.Context;

import com.loveqrc.cleanarchitecture.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
@Module
public class ApplicationModule {
    private final AndroidApplication mAndroidApplication;

    public ApplicationModule(AndroidApplication androidApplication) {
        mAndroidApplication = androidApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mAndroidApplication;
    }


}
