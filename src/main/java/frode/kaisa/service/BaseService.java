package frode.kaisa.service;

import org.springframework.stereotype.Component;

/**
 * @Author: frode
 * @Date: 2018/11/20 11:03
 * @Description:
 */
@Component
public interface BaseService {
    String transaction(Long[] ids);
}
