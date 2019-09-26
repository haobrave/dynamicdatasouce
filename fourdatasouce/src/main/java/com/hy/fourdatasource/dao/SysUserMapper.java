package com.hy.fourdatasource.dao;



import com.hy.fourdatasource.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SysUserMapper {
    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();
}