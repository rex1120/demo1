package com.lc.demo1.modules.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.demo1.modules.entity.SysFile;
import com.lc.demo1.modules.service.SysFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文件存储表(SysFile)表控制层
 *
 * @author lc
 * @since 2020-12-14 09:49:50
 */
@RestController
@RequestMapping("sysFile")
public class SysFileController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysFileService sysFileService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysFile 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysFile> page, SysFile sysFile) {
        return success(this.sysFileService.page(page, new QueryWrapper<>(sysFile)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysFileService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysFile 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysFile sysFile) {
        return success(this.sysFileService.save(sysFile));
    }

    /**
     * 修改数据
     *
     * @param sysFile 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysFile sysFile) {
        return success(this.sysFileService.updateById(sysFile));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysFileService.removeByIds(idList));
    }
}
