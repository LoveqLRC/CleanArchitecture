package com.loveqrc.cleanarchitecture.di.components;

import com.loveqrc.cleanarchitecture.di.PerActivity;
import com.loveqrc.cleanarchitecture.di.modules.ActivityModule;
import com.loveqrc.cleanarchitecture.di.modules.UserModule;
import com.loveqrc.cleanarchitecture.view.fragment.UserListFragment;

import dagger.Component;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(UserListFragment userListFragment);
}
