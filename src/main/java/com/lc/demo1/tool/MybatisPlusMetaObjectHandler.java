package com.lc.demo1.tool;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充器
 * @description: 为相关空值属性提供默认值
 * @author: lc
 * @time: 2020/11/24 16:10
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate", new Date(),metaObject);
        this.setFieldValByName("updateDate", new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDate", new Date(),metaObject);
    }
}
