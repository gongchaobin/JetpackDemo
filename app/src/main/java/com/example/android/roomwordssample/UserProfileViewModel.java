package com.example.android.roomwordssample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-15 11:47
 * @desc :
 */
public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;

    public LiveData<User> getUser() {
        return user;
    }

    private int uid;

    public void init(int uid) {
        MutableLiveData<User> data = new MutableLiveData<>();

        this.uid = uid;
        User mUser = new User();
        mUser.uid = uid;

        data.setValue(mUser);

        user = data;
    }

}
