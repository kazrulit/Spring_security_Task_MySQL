package kz.epam.service;

import kz.epam.model.User;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
public interface UserService {
    User findById(int id);
    User findBySso(String sso);
}
