package net.neoremind.resultutil.support;

import net.neoremind.resultutil.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * Stream Utility
 *
 * @author zhangxu
 */
public class StreamUtil {

    protected static final Logger logger = LoggerFactory.getLogger(ResourceBundleFactory.class);

    /**
     * 关闭流
     *
     * @param closed 可关闭的流
     */
    public static void close(Closeable closed) {
        if (closed != null) {
            try {
                closed.close();
            } catch (IOException ignore) {
                logger.error("close error", ignore);
            }
        }
    }
}
