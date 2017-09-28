package com.whl.service.impl;

import com.whl.jdbc.UserJdbc;
import com.whl.mapper.NewUserMapper;
import com.whl.mapper.UserMapper;
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

    //@Autowired
    //private UserMapper userMapper;

    @Autowired
    private NewUserMapper newUserMapper;

    public User getUserById(Long id)throws Exception{
        User user= newUserMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> getUserList()throws Exception {
        return newUserMapper.select(null);
    }

    @Override
    public void insertUser(User user)throws Exception {
        newUserMapper.insert(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        newUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) throws Exception{
        newUserMapper.updateByPrimaryKey(user);
    }
}
