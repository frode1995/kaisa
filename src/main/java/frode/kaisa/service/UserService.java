package frode.kaisa.service;

import frode.kaisa.domain.UserDO;

/**
 * @Author: frode
 * @Date: 2018/8/22 11:54
 * @Description:
 */
public interface UserService {
    UserDO getUserDOById(Long userId);
    UserDO getUserDOByUsername(String username);
    boolean valLogin(Long userId,String password);
}
