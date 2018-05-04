package com.loveqrc.cleanarchitecture.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loveqrc.cleanarchitecture.R;
import com.loveqrc.cleanarchitecture.di.components.UserComponent;
import com.loveqrc.cleanarchitecture.model.UserModel;
import com.loveqrc.cleanarchitecture.presenter.UserListPresenter;
import com.loveqrc.cleanarchitecture.view.UserListView;
import com.loveqrc.cleanarchitecture.view.adapter.UsersAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class UserListFragment extends BaseFragment implements UserListView {
    public interface UserListListener {
        void onUserClicked(final UserModel userModel);
    }

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;

    @Inject
    UsersAdapter mUsersAdapter;

    Unbinder unbinder;
    private UserListListener userListListener;

    @Inject
    UserListPresenter userListPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof UserListListener) {
            userListListener = (UserListListener) getActivity();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(UserComponent.class).inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_user_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    private void setupRecyclerView() {
        mUsersAdapter.setOnItemClickListener(onItemClickListener);
        rvUsers.setLayoutManager(new LinearLayoutManager(context()));
        rvUsers.setAdapter(mUsersAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void renderUserList(Collection<UserModel> userModelCollection) {

    }

    @Override
    public void viewUser(UserModel userModel) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError() {

    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    private UsersAdapter.OnItemClickListener onItemClickListener =
            new UsersAdapter.OnItemClickListener() {
                @Override
                public void onUserItemClicked(UserModel userModel) {
//                    if (UserListFragment.this.userListPresenter != null && userModel != null) {
//                        UserListFragment.this.userListPresenter.onUserClicked(userModel);
//                    }
                }
            };
}
