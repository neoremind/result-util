package net.neoremind.resultutil.result;

/**
 * 从resource bundle中取得result code相关的message的接口。
 *
 * @author zhangxu
 */
public interface ResultCodeMessage {

    /**
     * 取得message所表达的<code>ResultCode</code>名称。
     *
     * @return <code>ResultCode</code>名称
     */
    String getName();

    /**
     * 取得message所表达的<code>ResultCode</code>值。
     *
     * @return <code>ResultCode</code>值
     */
    ResultCode getResultCode();

    /**
     * 取得message字符串。
     *
     * @return message字符串
     */
    String getMessage();

    /**
     * 取得code值。
     *
     * @return code值
     */
    int getCode();
}
