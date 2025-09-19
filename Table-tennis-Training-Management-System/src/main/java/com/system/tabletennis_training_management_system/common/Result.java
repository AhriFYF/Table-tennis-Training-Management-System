package com.system.tabletennis_training_management_system.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Long total;
    private Object data;

    public static Result fail(){
        return result(400, "fail", 0L, null);
    }

    public static Result success(){
        return result(200, "success", 0L, null);
    }

    public static Result success(Object data){
        return result(200, "success", 0L, data);
    }

    public static Result success(Object data, Long total){
        return result(200, "success", total, data);
    }

    private static Result result(int code, String msg, Long total, Object data) {
        Result result = new Result();
        result.setData(data);
        result.setMsg(msg);
        result.setCode(code);
        result.setTotal(total);
        return result;
    }

}
