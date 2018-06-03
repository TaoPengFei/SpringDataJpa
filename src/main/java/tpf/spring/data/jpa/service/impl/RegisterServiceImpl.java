package tpf.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpf.spring.data.jpa.entity.User;
import tpf.spring.data.jpa.repository.RegisterRepository;
import tpf.spring.data.jpa.service.RegisterService;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/6/3-20:32
 * @email: taopengfei1223@foxmail.com
 **/

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public Integer saveUser(User user) {
        return registerRepository.save(user);
    }
}
