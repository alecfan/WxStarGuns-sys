package com.stylefeng.guns.core.enums;

/**
 * @author haiyangp
 * date:  2018/4/8
 * desc: 返回码枚举
 */
public enum ResponseCodeEnum {
    /**
     * @Fields OK : 请求成功 <br/>
     * <p>
     * <p>
     * <p>
     * version: V2.0
     */
    OK(51200, "请求成功"),

    /**
     * 无数据
     */
    EMPTY_RESULT(51204, "无数据"),

    /**
     * @Fields ERROR_NOTFOUND : 资源不存在<br/>
     * <p>
     * <p>
     * <p>
     * version: V2.0
     */
    ERROR_NOTFOUND(51404, "资源不存在"),

    /**
     * @Fields ERROR_SERVER : 服务器错误<br/>
     * <p>
     * <p>
     * <p>
     * version: V2.0
     */
    ERROR_SERVER(51500, "服务器错误"),

    /**
     * @Fields ERROR : 请求失败<br/>
     * <p>
     * <p>
     * <p>
     * version: V2.0
     */
    ERROR(51400, "请求失败"),

    /**
     * @Fields ERROR_PARAM_NULL :参数为空 <br/>
     * <p>
     * <p>
     * <p>
     * version: V2.0
     */
    ERROR_PARAM_NULL(51401, "参数为空"),

    /**
     * 参数错误
     */
    ERROR_PARAM_ERROR(51406, "参数错误"),

    /**
     * 签名字符串为空
     */
    SIGN_IS_NULL(51402, "签名字符串为空"),

    /**
     * 签名错误
     */
    SIGN_IS_ERROR(51403, "签名错误"),

    /**
     * token过期
     */
    TOKEN_EXPIRED_ERROR(51500, "token过期"),

    /**
     * token错误
     */
    TOKEN_AUTH_ERROR(51501, "token错误");

    private int code;
    private String desc;

    private ResponseCodeEnum(Integer code, String descStr) {
        this.code = code;
        this.desc = descStr;
    }

    /**
     * Title: 获取状态码<br/>
     * <p>
     * <p>
     * <p>
     * Description: <br/>
     * <p>
     * <p>
     * <p>
     * author: puhaiyang<br/>
     * <p>
     * <p>
     * <p>
     * date: 2016年10月28日 上午10:32:33<br/>
     * <p>
     * <p>
     * <p>
     * version: V1.0<br/>
     *
     * @return<br/> Integer
     */
    public int Code() {
        return this.code;
    }

    /**
     * @return
     * @title 请求说明
     * @auther puhaiyang
     * @time 2017年1月30日上午10:14:50
     * @desc
     */
    public String Desc() {
        return this.desc;
    }
}
