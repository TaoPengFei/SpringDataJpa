package tpf.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpf.spring.data.jpa.entity.User;
import tpf.spring.data.jpa.repository.UserRepository;
import tpf.spring.data.jpa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer saveUser() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("password");
        return userRepository.save(user);
    }
}
