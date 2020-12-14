package com.lc.demo1.modules.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.lc.demo1.modules.entity.SysUser;
import com.lc.demo1.modules.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表控制层
 *
 * @author lc
 * @since 2020-12-14 09:49:55
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * @Author lc
     * @Description 保存或更新用户信息
     * @Date 2020/9/10 9:35
     * @Param [sysUser]
     * @return com.baomidou.mybatisplus.extension.api.R
     */
    @PostMapping("saveOrUpdateUser")
    public R saveOrUpdateUser(@RequestBody SysUser sysUser){
        return success(sysUserService.saveOrUpdateUser(sysUser));
    }

    /**
     * @Author lc
     * @Description 用户分页列表
     * @Date 2020/9/10 9:45
     * @Param [sysUser]
     * @return com.baomidou.mybatisplus.extension.api.R
     */
    @PostMapping("userPageList")
    public R userPageList(@RequestBody SysUser sysUser){
        return success( sysUserService.page((IPage<SysUser>) sysUser.getPage(),new QueryWrapper<SysUser>().lambda().eq(ObjectUtil.isNotEmpty(sysUser.getGender()),SysUser::getGender,sysUser.getGender()).like(StringUtils.isNotEmpty(sysUser.getUserName()),SysUser::getUserName,sysUser.getUserName()).orderBy(true,sysUser.getIsAsc(), sysUser.getOrderColumnStr(sysUser.getOrderColumn()))));
    }

}
