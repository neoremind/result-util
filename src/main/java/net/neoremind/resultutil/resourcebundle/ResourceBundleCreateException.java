package net.neoremind.resultutil.resourcebundle;

import java.text.MessageFormat;

/**
 * 表示创建<code>ResourceBundle</code>失败的异常.
 * 
 * @author zhangxu
 */
public class ResourceBundleCreateException extends Exception {

    private static final long serialVersionUID = 3258132457613177654L;

    /**
     * 构造一个异常, 指明引起这个异常的起因.
     * 
     * @param messageId 详细信息ID
     * @param params 详细信息参数
     * @param cause 异常的起因
     */
    public ResourceBundleCreateException(String messageId, Object[] params, Throwable cause) {
        super(MessageFormat.format(messageId, (params == null) ? new Object[0] : params), cause);
    }
}
