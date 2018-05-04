package com.loveqrc.cleanarchitecture.domain.repository;

import com.loveqrc.cleanarchitecture.model.UserModel;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public interface UserRepository {
    Observable<List<UserModel>> users();

    Observable<UserModel> user(int userId);

}
