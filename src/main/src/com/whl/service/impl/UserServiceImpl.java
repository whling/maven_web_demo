package com.whl.service.impl;

import com.whl.jdbc.UserJdbc;
import com.whl.pojo.User;
import com.whl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 16:43 2016/12/31
 * @Modified By:
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJdbc userJdbc;

    public User getUserById(Long id)throws Exception{
        User user= userJdbc.getUserById(id);
        return user;
    }

    @Override
    public List<User> getUserList()throws Exception {
        return userJdbc.getUserList();
    }

    @Override
    public void insertUser(User user)throws Exception {
        userJdbc.insertUser(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        userJdbc.deleteUser(id);
    }

    @Override
    public void updateUser(User user) throws Exception{
        userJdbc.updateUser(user);
    }
}
