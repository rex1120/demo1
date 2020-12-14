package com.lc.demo1.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.demo1.modules.entity.SysUser;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author lc
 * @since 2020-12-14 09:49:55
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 新增用户或更新
     * @Author lc
     * @Description //TODO
     * @Date 2020/12/14 10:37
     * @Param [sysUser]
     * @return com.lc.demo1.modules.entity.SysUser
     */
    SysUser saveOrUpdateUser(SysUser sysUser);
}
