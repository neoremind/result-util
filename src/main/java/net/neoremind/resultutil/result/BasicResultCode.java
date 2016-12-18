package net.neoremind.resultutil.result;

/**
 * 常用处理结果的代码
 *
 * @author zhangxu
 */
public enum BasicResultCode implements ResultCode {

    /**
     * 成功执行命令。
     */
    SUCCESS,

    /**
     * 参数不合法。
     */
    INVALID_PARAM,

    /**
     * 表示抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    GENERAL_FAILURE,

    /**
     * 表示service抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    SERVICE_FAILURE,

    /**
     * 表示DAO抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    DAO_FAILURE,

    /**
     * 执行业务逻辑操作失败。
     */
    BIZ_FAILURE,

    /**
     * 执行命令错误，一般会带有捕获的异常
     */
    ERROR;

    private final ResultCodeUtil util = new ResultCodeUtil(this);

    public String getName() {
        return util.getName();
    }

    public ResultCodeMessage getMessage() {
        return util.getMessage();
    }

    public int getCode() {
        return util.getCode();
    }

}
