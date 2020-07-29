package com.mrrookie.gkb.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author PengchengWang
 * @className com.mrrookie.gkb.common.ApiCode
 * @createDate 2020/7/28 10:37
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ApiCode {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 保存失败
     */
    SAVE_FAILURE(9999, "保存失败"),
    /**
     * 删除失败
     */
    DELETE_FAILURE(9998, "删除失败"),
    /**
     * 更新失败
     */
    UPDATE_FAILURE(9997, "更新失败"),
    /**
     * 数据不存在
     */
    DATA_NOT_EXIST(9996, "数据不存在"),
    ;

    @Setter
    @Getter
    Integer code;

    @Setter
    @Getter
    String msg;

}
