package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private boolean flag;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
        this.flag=true;
        this.code=StatusCode.OK;
        this.message="";
    }

    public Result(Object data) {
        this.flag=true;
        this.code=StatusCode.OK;
        this.message="";
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
