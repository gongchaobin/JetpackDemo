package com.example.android.roomwordssample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-15 11:46
 * @desc :
 */
public class UserProfileFragment extends Fragment {

    private static final String UID_KEY = "uid";
    private UserProfileViewModel mUserProfileViewModel;

    private static final String TAG = UserProfileFragment.class.getSimpleName();

    public static UserProfileFragment newInstance(int uid) {

        Bundle args = new Bundle();
        args.putInt(UID_KEY,uid);
        
        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        int uid = getArguments().getInt(UID_KEY);

        mUserProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        mUserProfileViewModel.init(uid);
        mUserProfileViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.i(TAG,"onChanged");
            }
        });

        super.onActivityCreated(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    
}
