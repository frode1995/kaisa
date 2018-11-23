package frode.kaisa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: frode
 * @Date: 2018/11/20 13:43
 * @Description:  用户登录的各项信息的实体类
 */
public class InfoDO implements Serializable {

    private static final long serialVersionUID = 1774459320141354402L;

    private Long infoId;
    private LocalDateTime loginTime;//登录时间 不知道LocalDateTime是否可以转成数据库中的datetime
    private Long userId;//用户表中对应的是id
    private Double latitude;//纬度
    private Double longitude;//经度

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
