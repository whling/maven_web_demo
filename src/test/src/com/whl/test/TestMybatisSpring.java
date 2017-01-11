package com.whl.test;

import com.whl.mapper.UserMapper;
import com.whl.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 16:24 2017/1/11
 * @Modified By:
 * @Description:
 */
public class TestMybatisSpring {
    private ApplicationContext applicationContext = null;
    private UserMapper userMapper;

    @Before
    public void init() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-*.xml"});
        userMapper = (UserMapper) applicationContext.getBean("userMapper");
    }

    //@Test
    //public void testSelectOne2() throws Exception {
    //    User user = userMapper.findUserById(5);
    //    System.out.println(user.getUsername());
    //}

    @Test
    public void testSelectListByCondition() throws Exception {
        List<User> users = userMapper.findUserListByCondition("whl");
        System.out.println(users.size());
    }
//    @Test
//    public void testfindUserList() throws Exception {
//        session = sqlSessionFactory.openSession();
//        QueryVo queryVo=new QueryVo();
//        User user=new User();
//        user.setUsername("whling");
//        queryVo.setUser(user);
//        int[] ids={4,5,10,12};
////		List<User> users = session.selectList("user.findUserList", queryVo);
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<User> users = userMapper.findUserList(queryVo);
//        System.out.println(users.size());
//    }

    //@Test
    //public void testInsertUser() throws Exception {
    //    User user = new User();
    //    user.setUsername("kobe");
    //    user.setPassword("kobe");
    //    user.setAddress("Los Angeles");
    //    user.setBirthday(new Date());
    //    user.setDescrible("basketball player");
    //    /*session.insert("user.insertUser", user);*/
    //    userMapper.insertUser(user);
    //    // 提交事务
    //    System.out.println(user.getId());
    //}

//    @Test
//    public void testUpdateUser() throws Exception {
//        session = sqlSessionFactory.openSession();
//        UserMapper userMapper = session.getMapper(UserMapper.class);
////		User user = session.selectOne("user.findUserById", 13);
//        User user = userMapper.findUserById(13);
//        user.setUsername("maolin");
//        user.setPassword("maolin");
//        user.setAddress("jilin");
//        user.setDescrible("a college student");
////		session.update("user.updateUser", user);
//
//        userMapper.updateUser(user);
//        // 提交事务
//        session.commit();
//    }
//
//    @Test
//    public void testDeleteUser() throws Exception {
//        session = sqlSessionFactory.openSession();
//        int id = 4;
////		session.delete("user.deleteUserById", 11);
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        userMapper.deleteUserById(id);
//        // 提交事务
//        session.commit();
//    }

}
