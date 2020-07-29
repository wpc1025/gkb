package com.mrrookie.gkb.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author PengchengWang
 * @className AddSchoolForm
 * @createDate 2020/7/24 10:59
 */
@Data
@ApiModel("添加学校请求表单")
public class AddSchoolForm {
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
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("邮政编码")
    private String postalCode;
}
