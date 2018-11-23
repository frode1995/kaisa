package frode.kaisa.dao;

import frode.kaisa.domain.InfoDO;
import frode.kaisa.sql.SqlFactory;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;

/**
 * @Author: frode
 * @Date: 2018/11/20 15:47
 * @Description:
 */
@Mapper
public interface InfoMapper {
    //type指明SQL工厂类，method是工厂类里对应的方法

    @InsertProvider(type = SqlFactory.class,method = "insertInfo")
    boolean saveInfo(@Param("info") InfoDO infoDO);
}
