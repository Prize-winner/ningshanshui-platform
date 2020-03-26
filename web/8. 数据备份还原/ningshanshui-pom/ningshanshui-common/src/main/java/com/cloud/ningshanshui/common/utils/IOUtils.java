package com.cloud.ningshanshui.common.utils;

import java.io.Closeable;
import java.io.IOException;


/**
 * <p>Title: IO相关工具类</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-24 16:36
 */

public class IOUtils {

	/**
	 * 关闭对象，连接
	 * @param closeable
	 */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
