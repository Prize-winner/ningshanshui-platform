package com.cloud.ningshanshui.service;

import com.cloud.ningshanshui.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

}