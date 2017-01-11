package com.whl.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Whling
 * @Date: Created in 14:55 2017/1/2
 * @Modified By:  使用jdbctemplate时使用
 * @Description:
 */
public class UserMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setAddress(resultSet.getString("address"));
        user.setDescrible(resultSet.getString("describle"));
        user.setBirthday(resultSet.getDate("birthday"));
        return user;
    }
}
