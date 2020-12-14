package com.lc.demo1.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.demo1.modules.dao.SysFileDao;
import com.lc.demo1.modules.entity.SysFile;
import com.lc.demo1.modules.service.SysFileService;
import org.springframework.stereotype.Service;

/**
 * 文件存储表(SysFile)表服务实现类
 *
 * @author lc
 * @since 2020-12-14 09:49:50
 */
@Service("sysFileService")
public class SysFileServiceImpl extends ServiceImpl<SysFileDao, SysFile> implements SysFileService {

}
