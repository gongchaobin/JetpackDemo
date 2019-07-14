package com.example.android.roomwordssample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-14 19:52
 * @desc :
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final UserDao userDao = UserRoomDatabase.getDatabase(this).getUserDao();


        User user = new User();
        user.uid  = 11;
        user.firstName = "gong";
        user.lastName = "cb";
        user.age = 23;

        new InsertUserTask(userDao).execute(user);
    }


    class InsertUserTask extends AsyncTask<User,Void,Void> {

        private UserDao mUserDao;

        public InsertUserTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            Long along = mUserDao.insert(users[0]);
            Log.i("json","along: " + along);
            return null;
        }
    }


}
