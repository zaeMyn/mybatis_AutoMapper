package com.zzm.model;

import com.zzm.enums.SexEnum;
import java.io.Serializable;

public class UserEntity implements Serializable {
    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 用户名称
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 1：男，2：女，-1：未知。
     *
     * @mbg.generated
     */
    private SexEnum sex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", description=").append(description);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}