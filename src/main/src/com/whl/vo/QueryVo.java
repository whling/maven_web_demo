package com.whl.vo;

import com.whl.pojo.User;

/**
 * @Author: Whling
 * @Date: Created in 16:16 2017/1/11
 * @Modified By:
 * @Description:
 */
public class QueryVo {
    private User user;

    private int[] ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
