package com.loveqrc.cleanarchitecture.presenter;

import com.loveqrc.cleanarchitecture.di.PerActivity;
import com.loveqrc.cleanarchitecture.domain.exception.ErrorBundle;
import com.loveqrc.cleanarchitecture.domain.interactor.DefaultObserver;
import com.loveqrc.cleanarchitecture.domain.interactor.GetUserList;
import com.loveqrc.cleanarchitecture.exception.ErrorMessageFactory;
import com.loveqrc.cleanarchitecture.model.UserModel;
import com.loveqrc.cleanarchitecture.view.UserListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
@PerActivity
public class UserListPresenter implements Presenter {
    private UserListView mUserListView;

    public void setUserListView(UserListView userListView) {
        mUserListView = userListView;
    }

    private final GetUserList mGetUserList;

    @Inject
    public UserListPresenter(GetUserList getUserList) {
        mGetUserList = getUserList;

    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetUserList.dispose();
        mUserListView = null;
    }


    public void initialize() {
        loadUserList();
    }

    private void loadUserList() {
        hideViewRetry();
        showViewLoading();
        getUserList();
    }

    private void getUserList() {
        mGetUserList.execute(new UserListObserver(), null);
    }

    private void showViewLoading() {
        mUserListView.showLoading();
    }

    private void hideViewRetry() {
        mUserListView.hideRetry();
    }


    private void hideViewLoading() {
        mUserListView.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String message = ErrorMessageFactory.create(mUserListView.context(), errorBundle.getException());
        mUserListView.showError(message);
    }

    private class UserListObserver extends DefaultObserver<List<UserModel>> {
        @Override
        public void onComplete() {
            hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
