package com.whl.controller;

import com.whl.pojo.User;
import com.whl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 17697 on 2016/12/17.
 * 利用springmvc发布rest风格的URL
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName(Model model)throws Exception{
        User user = this.userService.getUserById(1L);
        return user.getUsername();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = null;
        try {
            user = userService.getUserById(id);
            if(null==user){
                //资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // return ResponseEntity.status(HttpStatus.OK).body(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
            * 新增用户
     *
             * @param user
     * @return
             */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user) {
        try {
            this.userService.insertUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 更新用户资源
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user) {
        try {
            this.userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 删除用户资源
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id", defaultValue = "0") Long id) {
        try {
            if (id.intValue() == 0) {
                // 请求参数有误
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            this.userService.deleteUser(id);
            // 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
