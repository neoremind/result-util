package net.neoremind.resultutil.result;

/**
 * 处理结果的代码。实现代码的模板如下：
 * <p>
 * <pre>
 * public enum MyResultCode implements ResultCode {
 *     XYZ, ABC;
 *
 *     private final ResultCodeUtil util = new ResultCodeUtil(this);
 *
 *     public ResultCodeMessage getMessage() {
 *         return util.getMessage();
 *     }
 *
 *     public String getName() {
 *         return util.getName();
 *     }
 * }
 * </pre>
 *
 * @author zhangxu
 */
public interface ResultCode {

    /**
     * 成功执行命令。
     */
    ResultCode SUCCESS = BasicResultCode.SUCCESS;

    /**
     * 参数不合法。
     */
    ResultCode INVALID_PARAM = BasicResultCode.INVALID_PARAM;

    /**
     * 表示抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    ResultCode GENERAL_FAILURE = BasicResultCode.GENERAL_FAILURE;

    /**
     * 表示service抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    ResultCode SERVICE_FAILURE = BasicResultCode.SERVICE_FAILURE;

    /**
     * 表示DAO抛出未预料到异常，或者<code>isSuccess()</code>为<code>false</code>却未指明具体的 <code>ResultCode</code>。
     */
    ResultCode DAO_FAILURE = BasicResultCode.DAO_FAILURE;

    /**
     * 执行业务逻辑操作失败。
     */
    ResultCode BIZ_FAILURE = BasicResultCode.BIZ_FAILURE;

    /**
     * 执行命令错误，一般会带有捕获的异常
     */
    ResultCode ERROR = BasicResultCode.ERROR;

    /**
     * 创建result code的名称。
     */
    String getName();

    /**
     * 创建result code的描述信息。
     */
    ResultCodeMessage getMessage();

    /**
     * 创建code值
     */
    int getCode();
}
