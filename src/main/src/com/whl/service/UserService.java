package com.whl.service;

import com.whl.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 17697 on 2016/12/17.
 */
@Service
public interface UserService {
    public User getUserById(Long id)throws Exception;
    public List<User> getUserList()throws Exception;
    public void insertUser(User user)throws Exception;
    public void deleteUser(Long id)throws Exception;
    public void updateUser(User user)throws Exception;
}
