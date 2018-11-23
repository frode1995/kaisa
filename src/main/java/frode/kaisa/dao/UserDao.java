package frode.kaisa.dao;



import frode.kaisa.domain.UserDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
/**
 * @Author: frode
 * @Date: 2018/8/22 11:48
 * @Description:
 */
@Mapper
public interface UserDao {

    @Results(id = "User", value = {
            //@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
            @Result(property = "userId", column = "user_id", javaType = Long.class, jdbcType = JdbcType.BIGINT, id = true),//主键
            @Result(property = "username", column = "username", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "status", column = "status", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "sex", column = "sex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "mobile", column = "mobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "roleId", column = "role_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "picId", column = "pic_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(property = "modTime", column = "mod_time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(property = "headImg", column = "head_img", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "remark", column = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR)
            //jdbcType = JdbcType.TIMESTAMP, typeHandler = LocalDateTimeHandler.class),
    })//@Select 是查询类的注解，所有的查询均使用这个
    @Select("select * from user where user_id = #{userId}")//从教师表中查询tecId//错过
    UserDO getUserDOById(@Param("userId") Long userId);

    @Results(value = {
            //@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
            @Result(property = "userId", column = "user_id", javaType = Long.class, jdbcType = JdbcType.BIGINT, id = true),//主键
            @Result(property = "username", column = "username", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "status", column = "status", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "sex", column = "sex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "mobile", column = "mobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "roleId", column = "role_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "picId", column = "pic_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(property = "modTime", column = "mod_time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(property = "headImg", column = "head_img", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "remark", column = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR)
            //jdbcType = JdbcType.TIMESTAMP, typeHandler = LocalDateTimeHandler.class),
    })//@Select 是查询类的注解，所有的查询均使用这个
    @Select("select * from user where username = #{username}")//从教师表中查询tecId//错过
    UserDO getUserDOByUserName(@Param("username") String username);


}
