package com.lc.demo1.modules.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.demo1.modules.entity.SysMenuBar;
import com.lc.demo1.modules.service.SysMenuBarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单栏目列表（页面）(SysMenuBar)表控制层
 *
 * @author lc
 * @since 2020-12-14 09:49:54
 */
@RestController
@RequestMapping("sysMenuBar")
public class SysMenuBarController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuBarService sysMenuBarService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param sysMenuBar 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysMenuBar> page, SysMenuBar sysMenuBar) {
        return success(this.sysMenuBarService.page(page, new QueryWrapper<>(sysMenuBar)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysMenuBarService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysMenuBar 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysMenuBar sysMenuBar) {
        return success(this.sysMenuBarService.save(sysMenuBar));
    }

    /**
     * 修改数据
     *
     * @param sysMenuBar 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysMenuBar sysMenuBar) {
        return success(this.sysMenuBarService.updateById(sysMenuBar));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysMenuBarService.removeByIds(idList));
    }
}
