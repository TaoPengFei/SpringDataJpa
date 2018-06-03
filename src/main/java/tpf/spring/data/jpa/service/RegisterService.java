package tpf.spring.data.jpa.service;

import tpf.spring.data.jpa.entity.User;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/6/3-20:31
 * @email: taopengfei1223@foxmail.com
 **/
public interface RegisterService {
    Integer saveUser(User user);
}
