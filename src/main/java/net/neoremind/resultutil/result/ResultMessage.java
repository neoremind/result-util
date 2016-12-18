/**
 * 
 */
package net.neoremind.resultutil.result;

/**
 * 代表一个包含结果信息的接口
 * 
 * @author zhangxu
 */
public interface ResultMessage {

    /**
     * 获取结果代码
     * 
     * @return 处理结果的代码 @see ResultCode
     */
    ResultCode getResultCode();

}
