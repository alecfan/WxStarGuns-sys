package com.stylefeng.guns.core.base.bean;


import com.stylefeng.guns.core.enums.ResponseCodeEnum;

/**
 * @author haiyangp
 * date:  2018/4/8
 * desc:
 */
public class JsonResult extends BaseResult {
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 成功返回
     */
    public static JsonResult ok(Object data) {
        JsonResult responseResult = new JsonResult(data);
        responseResult.setCode(ResponseCodeEnum.OK.Code());
        responseResult.setMsg("success");
        return responseResult;
    }

    /**
     * 成功返回
     */
    public static JsonResult ok() {
        JsonResult responseResult = new JsonResult();
        responseResult.setCode(ResponseCodeEnum.OK.Code());
        responseResult.setMsg("success");
        return responseResult;
    }


    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
