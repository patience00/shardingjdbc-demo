package com.linchtech.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 107
 * @date: 2019-08-25 21:33
 * @description:
 **/
@Data
@Getter
@Setter
public class BasePO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;
    @TableField("delete_flag")
    private Boolean deleteFlag;
}
