package com.loveqrc.cleanarchitecture.domain.interactor;


import com.loveqrc.cleanarchitecture.domain.executor.PostExecutionThread;
import com.loveqrc.cleanarchitecture.domain.executor.ThreadExecutor;
import com.loveqrc.cleanarchitecture.domain.repository.UserRepository;
import com.loveqrc.cleanarchitecture.model.UserModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class GetUserList extends UseCase<List<UserModel>, Void> {

    private final UserRepository mUserRepository;

    @Inject
    public GetUserList(UserRepository userRepository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mUserRepository = userRepository;
    }

    @Override
    Observable<List<UserModel>> buildUseCaseObservable(Void aVoid) {

        return mUserRepository.users();
    }
}
