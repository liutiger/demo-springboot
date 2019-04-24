package com.liuxl.common.demoEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/4/24
 */
public enum  DemoCode {
    NO_PRIVILEGE("NO_PRIVILEGE","无权限操作"),

    ILLGAL_ARGUMENT("ILLGAL_ARGUMENT","非法参数"),

    REPEAT_SUBMIT("REPEAT_SUBMIT","重复提交"),

    IDEMPOTENT_INVOKE("IDEMPOTENT_INVOKE","幂等调用"),

    PARAM_ISNULL("PARAM_ISNULL","参数为空"),

    CALL_DAO_ERROR("CALL_DAO_ERROR","网络异常")
    ;

    private String errMsg;

    private String errCode;

    private DemoCode(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private DemoCode(String errCode){
        this.errCode = errCode;
    }

    public static DemoCode getTbcpErrorCodeEnum(String code) {
        for(DemoCode x: DemoCode.values()) {
            if(x.getErrCode().equals(code)) {
                return x;
            }
        }
        return null;
    }

    public String getErrCode(){
        return this.errCode;
    }

    public String getErrMsg(){
        return this.errMsg;
    }
}
