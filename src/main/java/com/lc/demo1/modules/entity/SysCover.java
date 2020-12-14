package com.lc.demo1.modules.entity;

import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 加密表(SysCover)实体类
 *
 * @author lc
 * @since 2020-12-14 14:18:48
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
     * 创建时间
     */
    private Date createDate;
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
     * 文件存储表(SysFile)实体类
     *
     * @author lc
     * @since 2020-12-14 14:18:46
     */

    @EqualsAndHashCode(callSuper = true)
    @SuppressWarnings("serial")
    @Data
    @Table(name = "sys_file")
    public static class SysFile extends BasePojo {

        private Long id;
        /**
         * 文件名称
         */
        private String fileName;
        /**
         * 文件路径
         */
        private String fileUrl;
        /**
         * 文件存放空间（云存储，主机存储）
         */
        private String fileLocation;
        /**
         * 文件后缀
         */
        private String fileSuffix;
        /**
         * 文件大小(单位：B)
         */
        private Long fileSize;
        /**
         * 关联id
         */
        private Long relationId;
        /**
         * 关联表名
         */
        private String relationTable;
        /**
         * 上传人id
         */
        private String uploadUserId;
        /**
         * 删除标记（1：未删，0：已删）
         */
        private Integer delFlag;
        /**
         * 标签
         */
        private String tag;
        /**
         * 上传日期
         */
        private Date uploadDate;
        /**
         * 用途分类
         */
        private String assortment;
        /**
         * hash码
         */
        private String hashCode;


    }
}
