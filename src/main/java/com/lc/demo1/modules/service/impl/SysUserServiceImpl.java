package com.lc.demo1.modules.service.impl;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.demo1.modules.dao.SysUserDao;
import com.lc.demo1.modules.entity.SysCover;
import com.lc.demo1.modules.entity.SysUser;
import com.lc.demo1.modules.service.SysCoverService;
import com.lc.demo1.modules.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author lc
 * @since 2020-12-14 09:49:55
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {


    @Resource
    private SysCoverService sysCoverService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser saveOrUpdateUser(SysUser sysUser) {
        String rules = null;
        DES des = null;
        if (ObjectUtil.isEmpty(sysUser.getId())) {
            //随机生成密钥
            byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
            //构建des
            des = SecureUtil.des(key);
            //将字节转化为16进制字符串
            rules = HexUtil.encodeHexStr(key);
        }
        boolean result = sysUser.insertOrUpdate();
        if (result && StringUtils.isNotEmpty(rules)) {
            SysCover sysCover = new SysCover();
            sysCover.setRelationId(sysUser.getId());
            sysCover.setDesKeyHex(rules);
            sysCover.setTableName(sysUser.getTableName());
            sysCover.setCoverContent(des.encryptHex(sysUser.getPassword()));
            sysCoverService.save(sysCover);
        }
        return sysUser;
    }

}
