package frode.kaisa.service.impl;

import frode.kaisa.dao.UserDao;
import frode.kaisa.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: frode
 * @Date: 2018/11/20 11:41
 * @Description:
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    UserDao userMapper;

    @Override
    @Transactional //测试事务 批量删除再增加
    public String transaction(Long[] ids) {

        return null;
    }
}
