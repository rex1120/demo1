package com.lc.demo1.modules.entity;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lc.demo1.configuration.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 文件存储表(SysFile)实体类
 *
 * @author lc
 * @since 2020-12-17 15:01:11
 */

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@Table(name = "sys_file")
public class SysFile extends BasePojo {
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

    /**
     * @Author lc
     * @Description 重写基础公共类方法
     * @Date
     * @Param []
     */
    @Override
    public SFunction<SysFile, Object> getOrderColumnStr(String orderColumn) {
        SFunction<SysFile, Object> orderColumnFn;
        if (orderColumn != null) {
            switch (orderColumn) {
                case "fileName":
                    orderColumnFn = SysFile::getFileName;
                    break;
                case "fileUrl":
                    orderColumnFn = SysFile::getFileUrl;
                    break;
                case "fileLocation":
                    orderColumnFn = SysFile::getFileLocation;
                    break;
                case "fileSuffix":
                    orderColumnFn = SysFile::getFileSuffix;
                    break;
                case "fileSize":
                    orderColumnFn = SysFile::getFileSize;
                    break;
                case "relationId":
                    orderColumnFn = SysFile::getRelationId;
                    break;
                case "relationTable":
                    orderColumnFn = SysFile::getRelationTable;
                    break;
                case "uploadUserId":
                    orderColumnFn = SysFile::getUploadUserId;
                    break;
                case "tag":
                    orderColumnFn = SysFile::getTag;
                    break;
                case "uploadDate":
                    orderColumnFn = SysFile::getUploadDate;
                    break;
                case "assortment":
                    orderColumnFn = SysFile::getAssortment;
                    break;
                case "hashCode":
                    orderColumnFn = SysFile::getHashCode;
                    break;
                default:
                    this.isAsc = false;
                    orderColumnFn = SysFile::getCreateDate;
                    break;
            }
        } else {
            this.isAsc = false;
            orderColumnFn = SysFile::getCreateDate;
        }
        return orderColumnFn;
    }
}
