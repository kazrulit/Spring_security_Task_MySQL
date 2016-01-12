package kz.epam.dao;

import kz.epam.model.User;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
public interface UserDao {
    User findByID(int id);
    User findBySSO(String sso);
}
