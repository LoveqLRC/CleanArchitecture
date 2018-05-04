package com.loveqrc.cleanarchitecture.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
