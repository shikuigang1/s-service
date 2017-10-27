package com.skg.service.core.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_admin")
public class Admin {
    @Id
    private Long id;

    private String username;

    private String password;

    private String mobile;

    private String status;

    /**
     * 存储用户access_token
     */
    private String attr1;

    private String attr2;

    private String attr3;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取0
     *
     * @return status - 0
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0
     *
     * @param status 0
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取存储用户access_token
     *
     * @return attr1 - 存储用户access_token
     */
    public String getAttr1() {
        return attr1;
    }

    /**
     * 设置存储用户access_token
     *
     * @param attr1 存储用户access_token
     */
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    /**
     * @return attr2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * @param attr2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * @return attr3
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * @param attr3
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }
}