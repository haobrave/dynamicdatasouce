package com.hy.fourdatasource.service.impl;


import com.hy.fourdatasource.dao.SysUserMapper;
import com.hy.fourdatasource.model.SysUser;
import com.hy.fourdatasource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }
}