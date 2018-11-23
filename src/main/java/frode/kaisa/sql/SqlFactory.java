package frode.kaisa.sql;

import frode.kaisa.domain.InfoDO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Author: frode
 * @Date: 2018/11/23 14:27
 * @Description:
 */
public class SqlFactory {
    /**
     *@描述  插入信息的方法
     *@创建人  frode
     *@创建时间  2018/11/23 16:00
     *@修改人和其它信息
     */
    public String insertInfo(Map<String,Object> para){
        InfoDO infoDO = (InfoDO)para.get("info");//infoMapper中@Param的值
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_info");//插入表名
        if(infoDO.getInfoId()!=null){
            sql.VALUES("info_id",infoDO.getInfoId().toString());//value只能String
        }
        if (infoDO.getUserId()!=null){
            sql.VALUES("user_id",infoDO.getUserId().toString());
        }
        if(infoDO.getLatitude()!=null){//不为空 则插入
            sql.VALUES("latitude",infoDO.getLatitude().toString());
        }
        if(infoDO.getLongitude()!=null){
            sql.VALUES("longitude",infoDO.getLongitude().toString());
        }
        if (infoDO.getLoginTime()!=null){
            sql.VALUES("login_time",infoDO.getLoginTime().toString().substring(0,10));
            //sql.VALUES("login_time",infoDO.getLoginTime().toString().replace("T"," ").replace(":","-"));//或许需要format
        }
        return sql.toString();
    }

}
