package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 加密表(SysCover)实体类
 *
 * @author lc
 * @since 2020-12-17 15:20:38
 */

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@Table(name = "sys_cover")
public class SysCover extends BasePojo {
    /**
     * 关联id
     */
    private Long relationId;
    /**
     * 关联表名
     */
    private String tableName;

    /**
     * 使用状态（1：使用中，0：未使用）
     */
    private Integer useFlag;
    /**
     * 16位des的key
     */
    private String desKeyHex;
    /**
     * 加密的内容
     */
    private String coverContent;

    /**
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date
     * @Param []
     */
    @Override
    public SFunction<SysCover, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysCover, Object> orderColumnFn;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "relationId":
                    orderColumnFn = SysCover::getRelationId;
                    break;
                case "tableName":
                    orderColumnFn = SysCover::getTableName;
                    break;
                case "createDate":
                    orderColumnFn = SysCover::getCreateDate;
                    break;
                case "useFlag":
                    orderColumnFn = SysCover::getUseFlag;
                    break;
                case "desKeyHex":
                    orderColumnFn = SysCover::getDesKeyHex;
                    break;
                case "coverContent":
                    orderColumnFn = SysCover::getCoverContent;
                    break;
                default:
                    this.isAsc = false;
                    orderColumnFn = SysCover::getCreateDate;
                    break;
            }
        } else {
            this.isAsc = false;
            orderColumnFn = SysCover::getCreateDate;
        }
        return orderColumnFn;
    }
}
