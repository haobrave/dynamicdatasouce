package com.hy.fourdatasource.service;



import com.hy.fourdatasource.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

}