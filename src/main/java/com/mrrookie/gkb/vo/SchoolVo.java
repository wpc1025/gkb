package com.mrrookie.gkb.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author PengchengWang
 * @className SchoolVo
 * @createDate 2020/7/28 9:49
 */
@Data
@ApiModel("分页获取学校列表响应实体")
public class SchoolVo {
    @ApiModelProperty("学校ID")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("区县")
    private String county;
    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;
}
