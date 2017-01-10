package com.whl.jdbc;


import com.whl.pojo.User;
import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 21:23 2016/12/30
 * @Modified By:
 * @Description:
 */
public interface UserJdbc {
    public User getUserById(Long id)throws Exception;
    public List<User> getUserList()throws Exception;
    public void insertUser(User user)throws Exception;
    public void deleteUser(Long id)throws Exception;
    public void updateUser(User user)throws Exception;
}
