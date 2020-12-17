package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表(SysUser)实体类
 *
 * @author lc
 * @since 2020-12-17 15:01:15
 */

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@Table(name = "sys_user")
public class SysUser extends BasePojo {
    /**
     * 姓名（昵称）
     */
    private String userName;
    /**
     * 用户名
     */
    private String loginName;
    /**
     * 头像地址
     */
    private String headPicture;
    /**
     * 地址
     */
    private String address;
    /**
     * 出生日期
     */
    private Date bornDate;
    /**
     * 联系方式
     */
    private Object contactWay;


    /**
     * 性别
     */
    private Integer gender;

    /**
     * 密码
     */
    @TableField(exist = false)
    private String password;

    /**
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date
     * @Param []
     */
    @Override
    public SFunction<SysUser, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysUser, Object> orderColumnFn;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "userName":
                    orderColumnFn = SysUser::getUserName;
                    break;
                case "loginName":
                    orderColumnFn = SysUser::getLoginName;
                    break;
                case "headPicture":
                    orderColumnFn = SysUser::getHeadPicture;
                    break;
                case "address":
                    orderColumnFn = SysUser::getAddress;
                    break;
                case "bornDate":
                    orderColumnFn = SysUser::getBornDate;
                    break;
                case "contactWay":
                    orderColumnFn = SysUser::getContactWay;
                    break;
                case "createDate":
                    orderColumnFn = SysUser::getCreateDate;
                    break;
                case "updateDate":
                    orderColumnFn = SysUser::getUpdateDate;
                    break;
                case "gender":
                    orderColumnFn = SysUser::getGender;
                    break;
                default:
                    this.isAsc = false;
                    orderColumnFn = SysUser::getCreateDate;
                    break;
            }
        } else {
            this.isAsc = false;
            orderColumnFn = SysUser::getCreateDate;
        }
        return orderColumnFn;
    }
}
