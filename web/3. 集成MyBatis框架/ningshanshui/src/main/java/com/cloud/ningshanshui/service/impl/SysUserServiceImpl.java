package com.cloud.ningshanshui.service.impl;

import com.cloud.ningshanshui.dao.SysUserMapper;
import com.cloud.ningshanshui.model.SysUser;
import com.cloud.ningshanshui.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
}