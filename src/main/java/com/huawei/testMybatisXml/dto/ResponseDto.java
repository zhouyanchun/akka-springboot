package com.huawei.testMybatisXml.dto;

public class ResponseDto<T> {
    public static int SUCCESS_CODE = 0;
    public static int ERROR_MESSAGE_TYPE = -1;
    public static int OPERATION_NOT_FOUND = -2;
    public static int DB_OPERATION_ERROR = -3;
    private int code;
    private T data;
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess () {
        return this.code == SUCCESS_CODE;
    }

    public static <T> ResponseDto<T> buildSuccess(T data) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setCode(SUCCESS_CODE);
        responseDto.setData(data);
        return responseDto;
    }

    public static ResponseDto buildFail(int code, String msg) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(code);
        responseDto.setErrorMsg(msg);
        return responseDto;
    }
}
