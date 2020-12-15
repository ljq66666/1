package com.xxl.job.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author xuxueli 2020-04-12 0:14:00
 */
public class JdkSerializeTool {
    private static Logger logger = LoggerFactory.getLogger(JdkSerializeTool.class);

    // ------------------------ serialize and unserialize ------------------------

    /**
     * 将对象-->byte[] (由于jedis中不支持直接存储object所以转换成byte[]存入)
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)
        ) {
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }


    /**
     * 将byte[] -->Object
     *
     * @param bytes
     * @return
     */
    public static <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais)
        ) {
            return ois.readObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
