package com.loveqrc.cleanarchitecture.domain.exception;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class DefaultErrorBundle implements ErrorBundle {
    private static final String DEFAULT_ERROR_MSG = "Unknown error";

    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception != null) ? this.exception.getMessage() : DEFAULT_ERROR_MSG;
    }
}
