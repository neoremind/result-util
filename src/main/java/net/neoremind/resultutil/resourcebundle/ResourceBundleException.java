package net.neoremind.resultutil.resourcebundle;

import java.text.MessageFormat;
import java.util.MissingResourceException;

/**
 * 表示<code>ResourceBundle</code>未找到, 或创建失败的异常.
 * 
 * @author zhangxu
 */
public class ResourceBundleException extends MissingResourceException {

    private static final long serialVersionUID = 3258408434930825010L;

    private Throwable cause;

    /**
     * 构造一个异常, 指明引起这个异常的起因.
     * 
     * @param messageId 详细信息ID
     * @param params 详细信息参数
     * @param bundleName bundle名称
     * @param key resource key
     * @param cause 异常的起因
     */
    public ResourceBundleException(String messageId, Object[] params, String bundleName, Object key, Throwable cause) {
        super(MessageFormat.format(messageId, (params == null) ? new Object[0] : params), bundleName, String
                .valueOf(key));
        this.cause = cause;
    }

    /**
     * 取得bundle名.
     * 
     * @return bundle名
     */
    public String getBundleName() {
        return super.getClassName();
    }

    public Throwable getCause() {
        return (cause == this ? null : cause);
    }

}
