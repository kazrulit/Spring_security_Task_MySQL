package kz.epam.dao;

import kz.epam.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    public User findByID(int id) {
        return getByKey(id);
    }

    public User findBySSO(String sso) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId", sso));
        return (User) criteria.uniqueResult();
    }
}
