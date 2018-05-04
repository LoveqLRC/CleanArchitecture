package com.loveqrc.cleanarchitecture.di.components;

import android.content.Context;

import com.loveqrc.cleanarchitecture.di.modules.ApplicationModule;
import com.loveqrc.cleanarchitecture.view.activity.BaseActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity activity);

    Context cotext();

}
