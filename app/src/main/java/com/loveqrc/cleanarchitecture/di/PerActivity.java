package com.loveqrc.cleanarchitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
