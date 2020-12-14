package com.lc.demo1.configuration;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.io.Serializable;


/**
 * @description:
 * @author: lc
 * @time: 2020/9/17 14:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BasePojo extends Model<BasePojo> implements Serializable {


    private static final long serialVersionUID = 1L;

    public Long id;

    /**
     * 是否正序排序
     */
    @TableField(exist = false)
    public Boolean isAsc;

    /**
     * 排序字段
     */
    @TableField(exist = false)
    public String orderColumn;

    /**
     * 排序字段
     */
    @TableField(exist = false)
    public Page<?> page;

    /**
     * @Author lc
     * @Description 返回字段类型的lambda方法，继承的子类使用时需重写
     * @Date 2020/9/17 15:29
     * @Param []
     * @return java.util.function.Function<?,java.lang.Object>
     */
    public SFunction<?, Object> getOrderColumnStr(String orderColumn) {
        return null;
    }


    /**
     * 获取实体对应的表名
     * @Author lc
     * @Description //TODO
     * @Date 2020/12/14 14:25
     * @Param []
     * @return java.lang.String
     */
    public String getTableName() {
        Table annotation =  this.getClass().getAnnotation(Table.class);
        if (annotation != null) {
            return annotation.name();
        }
        return null;
    }
}
