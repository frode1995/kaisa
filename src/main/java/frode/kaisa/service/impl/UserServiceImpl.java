package frode.kaisa.service.impl;

import frode.kaisa.dao.UserDao;
import frode.kaisa.domain.UserDO;
import frode.kaisa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: frode
 * @Date: 2018/8/22 11:54
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO getUserDOById(Long userId) {
        return userDao.getUserDOById(userId);
    }

    @Override
    public UserDO getUserDOByUsername(String username) {
        return userDao.getUserDOByUserName(username);
    }

    @Override//验证登录
    public boolean valLogin(Long userId, String password) {
        if(userId == null||null==password||"".equals(password)){
            return false;
        }
        UserDO userDO = userDao.getUserDOById(userId);
        return  userDO.getUserId().equals(userId)&&userDO.getPassword().equals(password);
    }
}
