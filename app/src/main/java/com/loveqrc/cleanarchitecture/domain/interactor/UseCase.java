package com.loveqrc.cleanarchitecture.domain.interactor;

import com.loveqrc.cleanarchitecture.domain.executor.PostExecutionThread;
import com.loveqrc.cleanarchitecture.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public abstract class UseCase<T, Params> {
    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final CompositeDisposable mDisposable;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
        mDisposable = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        Observable<T> observable = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());

        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        mDisposable.add(disposable);
    }

}
