package kz.epam.service;

import kz.epam.model.User;
import kz.epam.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(int id) {
        return userDao.findByID(id);
    }

    public User findBySso(String sso) {
        return userDao.findBySSO(sso);
    }
}
