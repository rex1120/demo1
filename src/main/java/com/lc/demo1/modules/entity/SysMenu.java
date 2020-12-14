package com.lc.demo1.modules.entity;

import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 菜单表（后台管理）(SysMenu)实体类
 *
 * @author lc
 * @since 2020-12-14 14:12:35
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
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人
     */
    private Long createUserId;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 更新人
     */
    private Long updateUserId;
    /**
     * 0 : 伪删，1，未删
     */
    private Integer delFlag;


}
