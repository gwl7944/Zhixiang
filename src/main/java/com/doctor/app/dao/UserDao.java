package com.doctor.app.dao;

import com.doctor.app.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.dao
 * @ClassName: UserDao
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 19:12
 */
@Mapper
public interface UserDao {

    User userLogin(String user_name, String user_pwd);

    int insertUser(User user);

    List<User> selectAllUser();

    User selectUserById(Integer id);

    int updateUserSql(User user);

    int deleteUserSql(Integer id);
}
