package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表(SysUser)实体类
 *
 * @author lc
 * @since 2020-12-14 10:25:51
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
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 删除标记（1：未删，0：已删）
     */
    @TableLogic(value = "1",delval = "0")
    private Integer delFlag;

    /**
     * 密码
     */
    @TableField(exist = false)
    private String password;


    /**
     * @return java.util.function.Function<lc.common.sys.entity.SysUser, java.lang.Object>
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date 2020/9/17 15:29
     * @Param []
     */
    @Override
    public SFunction<SysUser, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysUser, Object> orderColumnFn ;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "bornDate":
                    orderColumnFn = SysUser::getBornDate;
                    break;
                case "userName":
                    orderColumnFn = SysUser::getUserName;
                    break;
                case "loginName":
                    orderColumnFn = SysUser::getLoginName;
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
