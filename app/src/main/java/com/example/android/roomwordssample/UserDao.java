package com.example.android.roomwordssample;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019-07-14 19:35
 * @desc :
 */
@Dao
public interface UserDao {


    @Query("SELECT * FROM user")
    List<User> getAllUser();

    /**
     * 根据条件查询 方法参数和注解的sql语句参数必须一一对应
     * @param userIds
     * @return
     */
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);


    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);


    @Query("SELECT * FROM user WHERE uid = :uid")
    User findByUid(int uid);


    /**
     * OnConflictStrategy.REPLACE表示如果已经有数据，那么就覆盖掉
     * 数据的判断通过主键进行匹配，也就是uid，非整个user对象
     * 返回Long数据表示，插入条目的主键值（uid）
     *
     * @param user
     * @return
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(User user);

    /**
     * 返回List<Long>数据表示被插入数据的主键uid列表
     * @param users
     * @return
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... users);

    /**
     * 返回List<Long>数据表示被插入数据的主键uid列表
     * @param users
     * @return
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<User> users);


    @Update()
    int update(User user);

    @Update()
    int updateAll(User... user);

    @Update()
    int updateAll(List<User> user);

    @Delete
    int delete(User user);

    @Delete
    int deleteAll(List<User> users);

    @Delete
    int deleteAll(User... users);


}
