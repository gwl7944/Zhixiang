package com.doctor.app.service.Impl;

import com.doctor.app.dao.UserDao;
import com.doctor.app.entity.User;
import com.doctor.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.service.Impl
 * @ClassName: UserServiceImpl
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 19:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean userLogin(String user_name, String user_pwd) {
        User user = userDao.userLogin(user_name,user_pwd);
        if (user!=null){
            return true;
        }
        return false;
    }

    @Override
    public int insertUser(User user) {
        int i = userDao.insertUser(user);
        return i;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }
}
