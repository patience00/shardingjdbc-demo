package com.linchtech.shardingdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linchtech.shardingdemo.entity.FileList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 107
 * @date 2019-01-26 15:05
 **/
@Mapper
@Repository
public interface MovieMapper extends BaseMapper<FileList> {

}
