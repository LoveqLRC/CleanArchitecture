package com.loveqrc.cleanarchitecture.navigation;

import android.content.Context;
import android.content.Intent;

import com.loveqrc.cleanarchitecture.view.activity.UserListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToUserList(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UserListActivity.class);
            context.startActivity(intent);
        }
    }

}
