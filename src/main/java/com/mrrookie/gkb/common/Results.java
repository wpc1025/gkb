package com.mrrookie.gkb.common;

/**
 * @author PengchengWang
 * @className com.mrrookie.gkb.common.Results
 * @createDate 2020/7/29 10:26
 */
public class Results {
    public static Result success() {
        return success(ApiCode.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return success(ApiCode.SUCCESS, data);
    }

    public static <T> Result<T> success(ApiCode apiCode, T data) {
        return new Result<>(apiCode.getCode(), apiCode.getMsg(), data);
    }

    public static Result failure(ApiCode apiCode) {
        return failure(apiCode, null);
    }

    public static <T> Result<T> failure(ApiCode apiCode, T data) {
        return new Result<>(apiCode.getCode(), apiCode.getMsg(), data);
    }
}
