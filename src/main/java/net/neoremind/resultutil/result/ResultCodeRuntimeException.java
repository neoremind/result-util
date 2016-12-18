package net.neoremind.resultutil.result;

/**
 * Result util类库封装的异常
 *
 * @author zhangxu
 */
public class ResultCodeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -5278506190465957728L;

    public ResultCodeRuntimeException() {
    }

    public ResultCodeRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultCodeRuntimeException(String message) {
        super(message);
    }

    public ResultCodeRuntimeException(Throwable cause) {
        super(cause);
    }

}
