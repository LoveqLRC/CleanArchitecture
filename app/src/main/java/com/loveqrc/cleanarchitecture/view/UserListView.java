package com.loveqrc.cleanarchitecture.view;

import com.loveqrc.cleanarchitecture.di.modules.UserModule;
import com.loveqrc.cleanarchitecture.model.UserModel;

import java.util.Collection;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public interface UserListView extends LoadDataView {
    void renderUserList(Collection<UserModel> userModelCollection);

    void viewUser(UserModel userModel);
}
