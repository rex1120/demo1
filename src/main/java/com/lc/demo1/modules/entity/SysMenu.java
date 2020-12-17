package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 菜单表（后台管理）(SysMenu)实体类
 *
 * @author lc
 * @since 2020-12-17 15:01:13
 */

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@Table(name = "sys_menu")
public class SysMenu extends BasePojo {
    /**
     * 父节点id
     */
    private Long parentId;
    /**
     * 栏目名称
     */
    private String name;


    /**
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date
     * @Param []
     */
    @Override
    public SFunction<SysMenu, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysMenu, Object> orderColumnFn;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "parentId":
                    orderColumnFn = SysMenu::getParentId;
                    break;
                case "name":
                    orderColumnFn = SysMenu::getName;
                    break;
                case "createDate":
                    orderColumnFn = SysMenu::getCreateDate;
                    break;
                case "updateDate":
                    orderColumnFn = SysMenu::getUpdateDate;
                    break;
                default:
                    this.isAsc = false;
                    orderColumnFn = SysMenu::getCreateDate;
                    break;
            }
        } else {
            this.isAsc = false;
            orderColumnFn = SysMenu::getCreateDate;
        }
        return orderColumnFn;
    }
}
