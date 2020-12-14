package com.lc.demo1.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.demo1.modules.dao.SysMenuDao;
import com.lc.demo1.modules.entity.SysMenu;
import com.lc.demo1.modules.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表（后台管理）(SysMenu)表服务实现类
 *
 * @author lc
 * @since 2020-12-14 09:49:53
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}
