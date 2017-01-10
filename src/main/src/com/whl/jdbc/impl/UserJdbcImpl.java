package com.whl.jdbc.impl;

import com.whl.jdbc.UserJdbc;
import com.whl.pojo.User;
import com.whl.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 21:24 2016/12/30
 * @Modified By:
 * @Description:
 */
@Repository
public class UserJdbcImpl implements UserJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Long id) throws Exception{
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        return user;
    }

    @Override
    public List<User> getUserList() throws Exception{
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new UserMapper());
        if (userList != null && userList.size() > 0) {
            return userList;
        }
        return null;
    }

    @Override
    public void insertUser(User user) throws Exception{
        String sql = "INSERT INTO user(username,password,address,describle,birthday) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getAddress(), user.getDescrible(), user.getBirthday());
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateUser(User user)throws Exception {
        String sql = "update user SET username=?,password=? where id=?";
        jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(), user.getId());
    }
}
