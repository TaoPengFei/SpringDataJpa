package tpf.spring.data.jpa.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tpf.spring.data.jpa.entity.User;
import tpf.spring.data.jpa.repository.RegisterRepository;

import java.util.List;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/6/3-20:39
 * @email: taopengfei1223@foxmail.com
 **/

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public User load(Integer id) {
        return (User) getCurrentSession().load(User.class, id);
    }

    @Override
    public User get(Integer id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(User entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        User user = load(id);
        getCurrentSession().delete(user);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
