package com.loveqrc.cleanarchitecture.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loveqrc.cleanarchitecture.R;
import com.loveqrc.cleanarchitecture.di.HasComponent;
import com.loveqrc.cleanarchitecture.di.components.DaggerUserComponent;
import com.loveqrc.cleanarchitecture.di.components.UserComponent;
import com.loveqrc.cleanarchitecture.model.UserModel;
import com.loveqrc.cleanarchitecture.view.fragment.UserListFragment;

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>
        , UserListFragment.UserListListener {

    private UserComponent mUserComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    private void initializeInjector() {
        mUserComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }


    @Override
    public UserComponent getComponent() {
        return mUserComponent;
    }

    @Override
    public void onUserClicked(UserModel userModel) {

    }
}
