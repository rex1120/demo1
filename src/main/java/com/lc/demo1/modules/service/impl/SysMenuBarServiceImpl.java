package com.lc.demo1.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.demo1.modules.dao.SysMenuBarDao;
import com.lc.demo1.modules.entity.SysMenuBar;
import com.lc.demo1.modules.service.SysMenuBarService;
import org.springframework.stereotype.Service;

/**
 * 菜单栏目列表（页面）(SysMenuBar)表服务实现类
 *
 * @author lc
 * @since 2020-12-14 09:49:54
 */
@Service("sysMenuBarService")
public class SysMenuBarServiceImpl extends ServiceImpl<SysMenuBarDao, SysMenuBar> implements SysMenuBarService {

}
