package com.loveqrc.cleanarchitecture.exception;

import android.content.Context;

import com.loveqrc.cleanarchitecture.R;
import com.loveqrc.cleanarchitecture.data.exception.NetworkConnectionException;
import com.loveqrc.cleanarchitecture.data.exception.UserNotFoundException;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class ErrorMessageFactory {
    private ErrorMessageFactory() {
    }

    public static String create(Context context, Exception exception) {
        String message = "UNKOWN ERROR";
        if (exception instanceof NetworkConnectionException) {
            message = "NetworkConnectionException";
        } else if (exception instanceof UserNotFoundException) {
            message = "UserNotFoundException";
        }
        return message;
    }
}
