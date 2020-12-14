package com.lc.demo1.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.demo1.modules.dao.SysCoverDao;
import com.lc.demo1.modules.entity.SysCover;
import com.lc.demo1.modules.service.SysCoverService;
import org.springframework.stereotype.Service;

/**
 * 加密表(SysCover)表服务实现类
 *
 * @author lc
 * @since 2020-12-14 09:49:48
 */
@Service("sysCoverService")
public class SysCoverServiceImpl extends ServiceImpl<SysCoverDao, SysCover> implements SysCoverService {

}
