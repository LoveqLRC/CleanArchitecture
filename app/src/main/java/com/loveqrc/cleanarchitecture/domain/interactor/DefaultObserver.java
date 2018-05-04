package com.loveqrc.cleanarchitecture.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class DefaultObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
