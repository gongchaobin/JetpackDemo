package com.example.android.roomwordssample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-14 19:42
 * @desc :
 */
@Database(entities = {User.class},version = 2)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    private static volatile UserRoomDatabase INSTANCE;

    static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, "user_database")
                            // 数据出问题 允许回滚到老版本
                            .fallbackToDestructiveMigration()
                            // 添加数据库变动迁移
                            .addMigrations(MIGRATION_1_2)
                            // 允许主线程进行数据库操作，但是不推荐这样做。会造成主线程lock以及ANR
//                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //数据库的具体变动，在之前的user表中添加了新的column，名字是age。
            //类型是integer，不为空，默认值是0
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN age INTEGER NOT NULL DEFAULT 0");
        }
    };



}
