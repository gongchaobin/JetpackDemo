package com.example.android.roomwordssample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-14 19:52
 * @desc :
 */
public class TestActivity extends AppCompatActivity {

    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();

        UserProfileFragment f = UserProfileFragment.newInstance(11);
        t.add(R.id.container,f).commit();


//        final UserDao userDao = UserRoomDatabase.getDatabase(this).getUserDao();
//        final UserDao userDao = WordRoomDatabase.getDatabase(this).userDao();
//
//        User user = new User();
//        user.uid  = 11;
//        user.firstName = "gong";
//        user.lastName = "cb";
//        user.age = 23;
//
//        new InsertUserTask(userDao).execute(user);


//        new AsyncTask<Void,Void,Void>() {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                User user = new User();
//                user.uid  = 12;
//                user.firstName = "gong";
//                user.lastName = "cb";
//                user.age = 23;
//
//                UserDao userDao = UserRoomDatabase.getDatabase(TestActivity.this).getUserDao();
//                long along = userDao.insert(user);
//                Log.i(TAG,"along: " + along);
//
//                return null;
//            }
//        }.execute();
    }

//
//    class InsertUserTask extends AsyncTask<User,Void,Void> {
//
//        private UserDao mUserDao;
//
//        public InsertUserTask(UserDao userDao) {
//            mUserDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(User... users) {
//            Long along = mUserDao.insert(users[0]);
//            Log.i(TAG,"along: " + along);
//            return null;
//        }
//    }


}
