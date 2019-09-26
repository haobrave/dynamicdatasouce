package com.hy.fourdatasource.controller;

import com.hy.fourdatasource.config.DataSource;
import com.hy.fourdatasource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author Louis
 * @date Jun 17, 2019
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    
    @DataSource(value="one")
    @RequestMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }
    
    @DataSource(value="two")
    @RequestMapping(value="/findAll2")
    public Object findAll2() {
        return sysUserService.findAll();
    }

    @DataSource(value="three")
    @RequestMapping(value="/findAll3")
    public Object findAll3() {
        return sysUserService.findAll();
    }

    @DataSource(value="four")
    @RequestMapping(value="/findAll4")
    public Object findAll4() {
        return sysUserService.findAll();
    }

}