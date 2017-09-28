package com.whl.mapper;

import com.whl.pojo.User;

import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 16:11 2017/1/11
 * @Modified By:
 * @Description:
 */
public interface UserMapper {
    public User findUserById(Long id) throws Exception;

    public List<User> findUserListByCondition(String username) throws Exception;

    public void insertUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUserById(Long id) throws Exception;
}
