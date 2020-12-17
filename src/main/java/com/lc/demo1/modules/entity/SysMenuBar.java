package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 菜单栏目列表（页面）(SysMenuBar)实体类
 *
 * @author lc
 * @since 2020-12-17 15:01:14
 */

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@Table(name = "sys_menu_bar")
public class SysMenuBar extends BasePojo {
    /**
     * 父节点id
     */
    private Long parentId;
    /**
     * 栏目名称
     */
    private String name;


    /**
     * 关联id
     */
    private Long relationId;
    /**
     * 栏目类型
     */
    private Long type;

    /**
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date
     * @Param []
     */
    @Override
    public SFunction<SysMenuBar, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysMenuBar, Object> orderColumnFn;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "parentId":
                    orderColumnFn = SysMenuBar::getParentId;
                    break;
                case "name":
                    orderColumnFn = SysMenuBar::getName;
                    break;
                case "createDate":
                    orderColumnFn = SysMenuBar::getCreateDate;
                    break;
                case "updateDate":
                    orderColumnFn = SysMenuBar::getUpdateDate;
                    break;
                case "relationId":
                    orderColumnFn = SysMenuBar::getRelationId;
                    break;
                case "type":
                    orderColumnFn = SysMenuBar::getType;
                    break;
                default:
                    this.isAsc = false;
                    orderColumnFn = SysMenuBar::getCreateDate;
                    break;
            }
        } else {
            this.isAsc = false;
            orderColumnFn = SysMenuBar::getCreateDate;
        }
        return orderColumnFn;
    }
}
