package model.services;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

import java.util.List;

/**
 * Created by a-morenets (alexey.morenets@gmail.com) on 14.12.2016.
 */
public class UserService {
    private UserDao userDao = DaoFactory.getInstance().creeateUserDao();

    void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    List<User> getAllUsers() {
    	
    	//        return userDao.;
    	return null;
    }
}
