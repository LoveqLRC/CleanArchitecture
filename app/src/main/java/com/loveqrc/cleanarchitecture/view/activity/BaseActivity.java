package com.loveqrc.cleanarchitecture.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.loveqrc.cleanarchitecture.AndroidApplication;
import com.loveqrc.cleanarchitecture.di.components.ApplicationComponent;
import com.loveqrc.cleanarchitecture.di.modules.ActivityModule;
import com.loveqrc.cleanarchitecture.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class BaseActivity extends AppCompatActivity {
    @Inject
    Navigator mNavigator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);

    }

    protected void addFragment(int containerId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, fragment);
        fragmentTransaction.commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
