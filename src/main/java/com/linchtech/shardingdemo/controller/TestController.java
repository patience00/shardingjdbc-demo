package com.linchtech.shardingdemo.controller;

import com.linchtech.shardingdemo.entity.FileList;
import com.linchtech.shardingdemo.mapper.MovieMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author 107
 * @date 2022-01-27 13:34
 * @description
 **/
@Api("测试")
@RequestMapping("/movie")
@RestController
public class TestController {

    private MovieMapper movieMapper;

    public TestController(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public FileList id(@PathVariable("id") Long id) {
        // TODO 存在写入主库,主库还未同步到从库的时候,读取该数据会查询不到数据,可以写入的时候同时写入缓存,查询时先查询缓存
        return movieMapper.selectById(id);
    }

    @PostMapping
    @ApiOperation("新增")
    public boolean save() {
        FileList fileList = new FileList();
        fileList.setUrl(UUID.randomUUID().toString());
        fileList.setName(UUID.randomUUID().toString());
        fileList.setGmtCreate(new Date());
        fileList.setGmtModified(new Date());
        fileList.setDeleteFlag(false);
        fileList.setType(0);
        // 插入成功,添加缓存
        if (movieMapper.insert(fileList) > 0) {
            return true;
        }
        return false;
    }

}
