package com.loveqrc.cleanarchitecture.domain.exception;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
