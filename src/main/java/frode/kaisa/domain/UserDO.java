package frode.kaisa.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: frode
 * @Date: 2018/8/22 11:43
 * @Description:
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = -5349838727708499428L;
    private Long userId;//用户id
    private String username; // 用户名
    private String name; // 用户真实姓名
    private String password; // 密码
    private String mobile;// 手机号
    private Integer status; // 状态 0:禁用/1:正常
    private Date createTime;// 创建时间
    private Date modTime;// 修改时间
    private Long roleId;//角色 1管理员2用户 3临时/访客
    private String sex;//性别 1男2女 3保密
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;//出生日期
    private Long picId;//图片ID
    private String headImg;//头像url
    private String remark;//备注
}
